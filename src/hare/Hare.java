package hare;
public abstract class Hare {

    protected int health;
    protected int maxHealth;
    protected double speed; // tiles per second
    protected int row;
    protected int col;
    protected int damage;
    
    protected boolean frozen = false;

    public Hare(int health, int damage, double speed, int row) {
        this.health = health;
        this.maxHealth = health;
        this.damage = damage;
        this.speed = speed;
        this.row = row;
        this.col = 9; // assuming right side spawn like PvZ
    }

    // called every game tick
    public void update() {
        if (frozen) return;

        move();
        attack();
    }

    public void move() {
        // default: move left
        col -= 1;
    }

    public void attack() {
        // override if needed
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health <= 0) {
        	health = 0;
        }
    }

    public void freeze(int seconds) {
        frozen = true;

        new Thread(() -> {
            try {
                Thread.sleep(seconds * 1000);
            } catch (InterruptedException e) {}
            frozen = false;
        }).start();
    }

    // getters
    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
