public class Main {
    public static void main(String[] args) {
        Game RacingJava = new RacingGame(new JavaDeveloper());
        Game RacingCpp = new RacingGame(new CppDeveloper());

        Game FootballJava = new FootballGame(new JavaDeveloper());
        Game FootballCpp = new FootballGame(new CppDeveloper());

        RacingJava.developGame();
        RacingCpp.developGame();

        FootballJava.developGame();
        FootballCpp.developGame();
    }
}
