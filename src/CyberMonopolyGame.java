import java.util.Arrays;

public class CyberMonopolyGame {
    public static void main(String[] args) {
        Game game = new Game(Arrays.asList("Tim", "Bob"));

        boolean gameOver = false;
        while (!gameOver) {
            game.playRound();
            for (Player p : game.players) {
                if (p.hasFiveServers()) {
                    gameOver = true;
                    break;
                }
            }
        }
    }
}
