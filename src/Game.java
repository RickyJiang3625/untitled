class Game {
    List<Player> players;
    int round = 1;
    Random rand = new Random();

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
    }

    public void playRound() {
        System.out.println("--- Round " + round + " ---");
        for (Player p : players) {
            p.earnIncome();
            System.out.println(p.name + " earns income. Money: $" + p.money);

            if (p.money >= 100) {
                Server newServer = new Server("Server-" + (p.servers.size() + 1));
                p.servers.add(newServer);
                p.money -= 100;
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