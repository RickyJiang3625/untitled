import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Game {
    List<Player> players;
    int round = 1;
    Random rand = new Random();
    int serverCost = 500;
    Scanner scanner = new Scanner(System.in);

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            Player player = new Player(name);
            Server startingServer = new Server("Server-1");
            player.servers.add(startingServer);
            players.add(player);
        }
    }

    public void playRound() {
        System.out.println("--- Round " + round + " ---");

        Player human = players.get(0);
        Player cpu = players.get(1);

        playerTurn(human);
        if (human.hasFiveServers()) {
            System.out.println(human.name + " has won by owning 5 servers!");
            System.exit(0);
        }

        cpuTurn(cpu);
        if (cpu.hasFiveServers()) {
            System.out.println(cpu.name + " has won by owning 5 servers!");
            System.exit(0);
        }

        round++;
    }

    private void playerTurn(Player p) {
        System.out.println(p.name + " | Servers: " + p.servers.size() + " | Money: $" + p.money);

        int income = 0;
        for (Server s : p.servers) {
            if (s.hp > 0) {
                int randomIncome = 10 + rand.nextInt(21);
                p.money += randomIncome;
                income += randomIncome;
            }
        }
        System.out.println("Income this round: $" + income + " -> Total: $" + p.money);

        System.out.println("1. Buy server ($" + serverCost + ")  2. Skip");
        int choice = scanner.nextInt();

        if (choice == 1 && p.money >= serverCost) {
            Server newServer = new Server("Server-" + (p.servers.size() + 1));
            p.servers.add(newServer);
            p.money -= serverCost;
            System.out.println("Bought Server-" + p.servers.size());
        } else if (choice == 1) {
            System.out.println("Not enough money.");
        }
    }

    private void cpuTurn(Player p) {
        System.out.println("[CPU] " + p.name + " | Servers: " + p.servers.size() + " | Money: $" + p.money);

        int income = 0;
        for (Server s : p.servers) {
            if (s.hp > 0) {
                int randomIncome = 10 + rand.nextInt(21);
                p.money += randomIncome;
                income += randomIncome;
            }
        }
        System.out.println("CPU earned: $" + income + " -> Total: $" + p.money);

        if (p.money >= serverCost) {
            Server newServer = new Server("Server-" + (p.servers.size() + 1));
            p.servers.add(newServer);
            p.money -= serverCost;
            System.out.println("CPU bought Server-" + p.servers.size());
        }
    }
}
