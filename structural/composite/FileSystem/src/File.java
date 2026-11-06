public class File implements FileSystem {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        show();
    }

    @Override
    public void show(String indent) {
        System.out.println(indent + "File: " + name);
    }
}
