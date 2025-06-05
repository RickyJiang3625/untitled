abstract class Card {
    String name;
    abstract void play(Player user, Player target, Server server);
}