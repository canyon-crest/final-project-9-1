package powerup;
public class FoodAttack {

    private int damage;

    public FoodAttack(int damage) {
        this.damage = damage;
    }

    public void apply(Game g, int row) {
        for (Hare h : g.getHares()) {
            if (h.getRow() == row) {
                h.loseHealth(damage);
            }
        }
    }
}