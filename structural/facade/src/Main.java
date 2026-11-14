public class Main {
    public static void main(String[] args) {
        TravelFacade travel = new TravelFacade();

        travel.bookTrip("Toshkent", "Istanbul", "Grand Hotel", 5, 4_500_000);
        System.out.println();
        travel.cancelTrip(4_500_000);
    }
}
