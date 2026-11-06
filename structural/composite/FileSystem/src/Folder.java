import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {
    private final String name;
    private final List<FileSystem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystem item) {
        children.add(item);
    }

    public void remove(FileSystem item) {
        children.remove(item);
    }

    @Override
    public void show() {
        show("");
    }

    @Override
    public void show(String indent) {
        System.out.println(indent + "Folder: " + name);
        String next = indent + "    ";
        for (FileSystem child : children) {
            child.show(next);
        }
    }
}
