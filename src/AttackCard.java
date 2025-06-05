class AttackCard extends Card {
    int damage;

    public AttackCard(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    void play(Player user, Player target, Server server) {
        server.takeDamage(damage);
        System.out.println(user.name + " attacks " + target.name + "'s server " + server.name + " for " + damage + " damage!");
    }
}
