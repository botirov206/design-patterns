import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Document original = new Document(1, "Shartnome", "Asosiy matn", "Ali Botirov", Arrays.asList("huquq", "2026"));

        DocumentFactory factory = new DocumentFactory(original);

        Document copy1 = factory.cloneDocument();
        Document copy2 = factory.cloneDocument();

        copy1.setTitle("Shartnoma — nusxa 1");
        copy1.setContent("Birinchi nusxa matni");
        copy1.setTags(Arrays.asList("nusxa", "1"));

        copy2.setTitle("Shartnoma — nusxa 2");
        copy2.setContent("Ikkinchi nusxa matni");
        copy2.setTags(Arrays.asList("nusxa", "2"));

        System.out.println(original);
        System.out.println(copy1);
        System.out.println(copy2);
    }
}
