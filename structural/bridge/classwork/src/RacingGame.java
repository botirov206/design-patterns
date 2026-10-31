public class RacingGame extends Game {
    public RacingGame(Developer developer) {
        super(developer);
    }

    @Override
    public void developGame() {
        System.out.println("Racing game development in progress ...");
        developer.writeCode();
        System.out.println("Racing game development completed");
    }
}
