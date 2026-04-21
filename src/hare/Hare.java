package hare;
public abstract class Hare {

    protected int health;
    protected int maxHealth;
    protected double speed; // tiles per second
    protected int row;
    protected int col;
    
    protected boolean frozen = false;

    public Hare(int health, double speed, int row) {
        this.health = health;
        this.maxHealth = health;
        this.speed = speed;
        this.row = row;
        this.col = 9; // assuming right side spawn like PvZ
    }

    // called every game tick
    public void update(Board board) {
        if (frozen) return;

        move(board);
        attackIfNeeded(board);
    }

    protected void move(Board board) {
        // default: move left
        col -= 1;
    }

    protected void attackIfNeeded(Board board) {
        // override if needed
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health <= 0) die();
    }

    public boolean isDead() {
        return health <= 0;
    }

    protected void die() {
        // remove from game
        Board.removeHare(this);
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
    public int getRow() { return row; }
    public int getCol() { return col; }
}
