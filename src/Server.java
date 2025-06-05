class Server {
    String name;
    int hp = 100;

    public Server(String name) {
        this.name = name;
    }

    public void takeDamage(int damage) {
        hp = Math.max(hp - damage, 0);
    }

    public boolean isDown() {
        return hp <= 0;
    }
}