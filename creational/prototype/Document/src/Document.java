import java.util.ArrayList;
import java.util.List;

public class Document implements Copyable {
    private int id;
    private String title;
    private String content;
    private String author;
    private List<String> tags;

    public Document(int id, String title, String content, String author, List<String> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.tags = new ArrayList<>(tags);
    }

    public Document(Document source) {
        this.id = source.id;
        this.title = source.title;
        this.content = source.content;
        this.author = source.author;
        this.tags = new ArrayList<>(source.tags);
    }

    @Override
    public Object clone() {
        return new Document(this);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(List<String> tags) {
        this.tags = new ArrayList<>(tags);
    }

    @Override
    public String toString() {
        return "Document{id=" + id
                + ", title='" + title + '\''
                + ", content='" + content + '\''
                + ", author='" + author + '\''
                + ", tags=" + tags + '}';
    }
}
