class DefenseCard extends Card {
    int repair;

    public DefenseCard(String name, int repair) {
        this.name = name;
        this.repair = repair;
    }

    @Override
    void play(Player user, Player target, Server server) {
        if (user.servers.contains(server)) {
            server.hp = Math.min(server.hp + repair, 100);
            System.out.println(user.name + " repairs server " + server.name + " by " + repair + " HP.");
        } else {
            System.out.println("You can only repair your own servers!");
        }
    }
}