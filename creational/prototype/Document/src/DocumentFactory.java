public class DocumentFactory {
    private Document document;

    public DocumentFactory(Document document) {
        this.document = document;
    }

    public Document cloneDocument() {
        return (Document) document.clone();
    }
}
