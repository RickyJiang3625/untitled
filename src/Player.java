import java.util.*;

class Player {
    String name;
    List<Server> servers = new ArrayList<>();
    int money = 0;
    List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void earnIncome() {
        for (Server s : servers) {
            if (s.hp > 0) {
                money += 50;
            }
        }
    }

    public void playCard(Card card, Player target, Server targetServer) {
        card.play(this, target, targetServer);
        hand.remove(card);
    }

    public boolean hasFiveServers() {
        return servers.size() >= 5;
    }
}
