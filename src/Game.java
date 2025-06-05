import java.util.List;
import java.util.ArrayList;
import java.util.Random;

class Game {
    List<Player> players;
    int round = 1;
    Random rand = new Random();
    int serverCost = 500;

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            Player player = new Player(name);
            Server startingServer = new Server("Starter-" + name);
            player.servers.add(startingServer);
            players.add(player);
        }
    }

    public void playRound() {
        System.out.println("--- Round " + round + " ---");
        for (Player p : players) {
            System.out.println(p.name + " has " + p.servers.size() + " servers.");
            for (Server s : p.servers) {
                System.out.println("  Server " + s.name + " HP: " + s.hp);
            }

            int income = 0;
            for (Server s : p.servers) {
                if (s.hp > 0) {
                    int randomIncome = 10 + rand.nextInt(21);
                    p.money += randomIncome;
                    income += randomIncome;
                }
            }
            System.out.println(p.name + " earns income. Money: $" + p.money + " (this round: $" + income + ")");

            if (p.money >= serverCost) {
                Server newServer = new Server("Server-" + (p.servers.size() + 1));
                p.servers.add(newServer);
                p.money -= serverCost;
                System.out.println(p.name + " bought a new server: " + newServer.name);
            }

            if (p.hasFiveServers()) {
                System.out.println(p.name + " has won by owning 5 servers!");
                return;
            }
        }
        round++;
    }
}
