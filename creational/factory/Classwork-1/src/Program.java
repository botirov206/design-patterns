public class Program {
    public static void main(String[] args) {
        DeveloperFactory javaDeveloperFactory = getDeveloperFactory("Java");
        Developer javaDeveloper = javaDeveloperFactory.createDeveloper();
        javaDeveloper.writeCode();

        DeveloperFactory cppDeveloperFactory = getDeveloperFactory("C++");
        Developer cppDeveloper = cppDeveloperFactory.createDeveloper();
        cppDeveloper.writeCode();
    }

    private static DeveloperFactory getDeveloperFactory(String language) {
        if (language.equals("Java")) {
            return new JavaDeveloperFactory();
        }
        if (language.equals("C++")) {
            return new CppDeveloperFactory();
        }
        throw new RuntimeException("Unknown language: " + language);
    }
}
