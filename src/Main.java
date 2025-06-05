public class Main {
    public static void main(String[] args) {
        Game game = new Game(Arrays.asList("Tim", "Bob"));
        while (true) {
            game.playRound();
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}
