package students;

import hare.Hare;

public class Kate extends Student{
	
	private int damage;
	private int range;
	
    public Kate(int row, int col, int d, int r) {
        // Name, Cost, Health, Cooldown, Row, Col
        super("Kate", 50, 100, 20, row, col);
        this.damage= d;
        this.range = r;
    }

	
	public void attack(Hare hare) {
		explode(hare);
	}
	
	public void explode(Hare hare) {
		hare.setHealth(hare.getHealth() - damage);
		System.out.println("Kate did " + damage + " damage on " + hare.getName());
	}
}