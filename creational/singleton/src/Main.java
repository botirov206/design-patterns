public class Main {
    public static void main(String[] args) {
        database prodDB = database.getInstance("jdbc:mysql://localhost/shop");
        database devDB = database.getInstance("jdbc:mysql://localhost/shop");

        System.out.println(prodDB == devDB);
    }
}
