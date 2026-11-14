public class TravelFacade {
    private final FlightBooking flightBooking = new FlightBooking();
    private final HotelBooking hotelBooking = new HotelBooking();
    private final Payment payment = new Payment();

    public void bookTrip(String from, String to, String hotel, int nights, double amount) {
        System.out.println("--- Sayohat bron qilinmoqda ---");
        flightBooking.book(from, to);
        hotelBooking.book(hotel, nights);
        payment.pay(amount);
        System.out.println("Sayohat muvaffaqiyatli bron qilindi");
    }

    public void cancelTrip(double amount) {
        System.out.println("--- Sayohat bekor qilinmoqda ---");
        flightBooking.cancel();
        hotelBooking.cancel();
        payment.refund(amount);
        System.out.println("Sayohat bekor qilindi, to'lov qaytarildi");
    }
}
