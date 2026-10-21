public class database {
    private static database instance;
    private final String url;

    private database(String url) {
        this.url = url;
        System.out.println("Database connected to " + url);
    }

    public static database getInstance(String url) {
        if (instance == null) {
            instance = new database(url);
        }
        return instance;
    }
}
