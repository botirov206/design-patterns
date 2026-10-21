# Design Patterns

Index for Advanced Programming design-pattern examples. Each example is its own repository. This repository only links them.

## Add a project

Publish the example as its own public repository first, then register it here:

```bash
node scripts/add-project.mjs \
  --pattern Builder \
  --name "HTTP request" \
  --summary "A fluent builder assembles an HTTP request." \
  --repo https://github.com/botirov206/http-request-builder
```

`--pattern` is the heading. A new name adds a section. An existing name appends a row. The command updates `catalog.json` and regenerates this README.

Commit and push this repository:

```bash
git add catalog.json README.md
git commit -m "Link HTTP request"
git push
```

Local project folders stay on your machine. They are ignored by git, so this index never becomes a copy of those repositories. Run instructions live in each example's README.

## Catalog

### Builder

| Example | What it shows | Repository |
| --- | --- | --- |
| PC classwork | A director walks a builder through a fixed recipe, and a fluent builder sets each part in a chain. The product is a PC (CPU, RAM, OS, storage, mouse, keyboard). | [builder-classwork](https://github.com/botirov206/builder-classwork) |
| HTTP request | A fluent builder assembles method, URL, headers, body, and a secure flag into an immutable request, then sends it. | [http-request-builder](https://github.com/botirov206/http-request-builder) |

```bash
git clone https://github.com/botirov206/builder-classwork.git
git clone https://github.com/botirov206/http-request-builder.git
```
