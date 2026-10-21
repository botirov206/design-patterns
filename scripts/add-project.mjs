import { readFileSync, writeFileSync } from "node:fs";
import { dirname, join } from "node:path";
import { fileURLToPath } from "node:url";

const root = join(dirname(fileURLToPath(import.meta.url)), "..");
const catalogPath = join(root, "catalog.json");
const readmePath = join(root, "README.md");

const usage = `Link a published example in this index. Source stays in its own repository.

Usage:
  node scripts/add-project.mjs --pattern <Pattern> --name <Name> --summary <Text> --repo <GitHub URL>

Example:
  node scripts/add-project.mjs \\
    --pattern Builder \\
    --name "HTTP request" \\
    --summary "A fluent builder assembles an HTTP request." \\
    --repo https://github.com/botirov206/http-request-builder

Options:
  --dry-run    Print the README section and do not write files
`;

function parseArgs(argv) {
  const args = {};
  for (let i = 0; i < argv.length; i++) {
    const token = argv[i];
    if (!token.startsWith("--")) {
      throw new Error(`Unexpected argument: ${token}`);
    }
    const key = token.slice(2);
    const next = argv[i + 1];
    if (next === undefined || next.startsWith("--")) {
      args[key] = true;
    } else {
      args[key] = next;
      i++;
    }
  }
  return args;
}

function requireText(args, key) {
  const value = args[key];
  if (typeof value !== "string" || value.trim() === "") {
    throw new Error(`Missing --${key}`);
  }
  return value.trim();
}

function normalizeRepo(url) {
  let repo = url.trim().replace(/\/+$/, "");
  if (repo.endsWith(".git")) {
    repo = repo.slice(0, -4);
  }
  const match = repo.match(/^https:\/\/github\.com\/([^/\s]+)\/([^/\s]+)$/);
  if (!match) {
    throw new Error("`--repo` must be a GitHub URL, such as https://github.com/owner/name");
  }
  return `https://github.com/${match[1]}/${match[2]}`;
}

function repoName(url) {
  return url.slice(url.lastIndexOf("/") + 1);
}

function cell(value) {
  return value.replaceAll("|", "\\|").replaceAll("\n", " ");
}

export function renderReadme(catalog) {
  const sections = catalog.patterns.map((pattern) => {
    const rows = pattern.projects
      .map((project) => {
        const label = repoName(project.repo);
        return `| ${cell(project.name)} | ${cell(project.summary)} | [${label}](${project.repo}) |`;
      })
      .join("\n");
    const clones = pattern.projects
      .map((project) => `git clone ${project.repo}.git`)
      .join("\n");
    return `### ${pattern.name}

| Example | What it shows | Repository |
| --- | --- | --- |
${rows}

\`\`\`bash
${clones}
\`\`\``;
  });

  const catalogBody = sections.length > 0 ? sections.join("\n\n") : "_No examples yet._";

  return `# Design Patterns

Index for Advanced Programming design-pattern examples. Each example is its own repository. This repository only links them.

## Add a project

Publish the example as its own public repository first, then register it here:

\`\`\`bash
node scripts/add-project.mjs \\
  --pattern Builder \\
  --name "HTTP request" \\
  --summary "A fluent builder assembles an HTTP request." \\
  --repo https://github.com/botirov206/http-request-builder
\`\`\`

\`--pattern\` is the heading. A new name adds a section. An existing name appends a row. The command updates \`catalog.json\` and regenerates this README.

Commit and push this repository:

\`\`\`bash
git add catalog.json README.md
git commit -m "Link HTTP request"
git push
\`\`\`

Local project folders stay on your machine. They are ignored by git, so this index never becomes a copy of those repositories. Run instructions live in each example's README.

## Catalog

${catalogBody}
`;
}

function loadCatalog() {
  return JSON.parse(readFileSync(catalogPath, "utf8"));
}

function findPattern(catalog, name) {
  return catalog.patterns.find((pattern) => pattern.name.toLowerCase() === name.toLowerCase());
}

function addProject(catalog, project) {
  let pattern = findPattern(catalog, project.pattern);
  if (!pattern) {
    pattern = { name: project.pattern, projects: [] };
    catalog.patterns.push(pattern);
  }
  const duplicate = catalog.patterns
    .flatMap((entry) => entry.projects)
    .find((existing) => existing.repo === project.repo);
  if (duplicate) {
    throw new Error(`${project.repo} is already listed as "${duplicate.name}"`);
  }
  pattern.projects.push({
    name: project.name,
    summary: project.summary,
    repo: project.repo,
  });
  return pattern.name;
}

function main() {
  const args = parseArgs(process.argv.slice(2));
  if (args.help || args.h) {
    console.log(usage);
    return;
  }

  const project = {
    pattern: requireText(args, "pattern"),
    name: requireText(args, "name"),
    summary: requireText(args, "summary"),
    repo: normalizeRepo(requireText(args, "repo")),
  };

  const catalog = loadCatalog();
  const patternName = addProject(catalog, project);
  const readme = renderReadme(catalog);

  if (args["dry-run"]) {
    console.log(readme);
    return;
  }

  writeFileSync(catalogPath, `${JSON.stringify(catalog, null, 2)}\n`);
  writeFileSync(readmePath, readme);
  console.log(`Linked "${project.name}" under ${patternName}.`);
  console.log("Review catalog.json and README.md, then commit and push this repository.");
}

if (process.argv[1] && fileURLToPath(import.meta.url) === process.argv[1]) {
  try {
    main();
  } catch (error) {
    console.error(error.message);
    console.error("");
    console.error(usage);
    process.exit(1);
  }
}
