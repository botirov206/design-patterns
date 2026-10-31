public class FootballGame extends Game {
    public FootballGame(Developer developer) {
        super(developer);
    }

    @Override
    public void developGame() {
        System.out.println("Football game development in progress ...");
        developer.writeCode();
        System.out.println("Football game development completed");
    }
}
