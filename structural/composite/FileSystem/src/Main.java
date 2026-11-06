public class Main {
    public static void main(String[] args) {
        Folder computer = new Folder("Computer");

        Folder documents = new Folder("Documents");
        documents.add(new File("resume.pdf"));
        documents.add(new File("homework.docx"));

        Folder university = new Folder("University");
        university.add(new File("Main.java"));
        university.add(new File("File.java"));
        documents.add(university);

        Folder photos = new Folder("Photos");
        photos.add(new File("photo1.jpg"));
        photos.add(new File("photo2.jpg"));

        computer.add(documents);
        computer.add(photos);
        computer.add(new File("music.mp3"));

        computer.show();
    }
}
