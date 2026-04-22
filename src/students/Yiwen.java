package students;

import hare.Hare;

public class Yiwen extends Student{
	
	private int damage;
	private int range;
	
    public Yiwen(int row, int col, int d, int r) {
        // Name, Cost, Health, Cooldown, Row, Col
        super("Yiwen", 50, 100, 20, row, col);
        this.damage= d;
        this.range = r;
    }

	
	public void attack(Hare hare) {
		paint(hare);
	}
	
	public void paint(Hare hare) {
		hare.setHealth(hare.getHealth() - damage);
		System.out.println("Yiwen did " + damage + " damage on " + hare.getName());
	}
}