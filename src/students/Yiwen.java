package students;

import hare.Hare;

public class Yiwen extends Student{
	
	private int damage;
	
    public Yiwen(int row, int col, int damage) {
        // Name, Cost, Health, Cooldown, Row, Col
        super("Yiwen", 50, 100, 20, row, col);
        this.damage= damage;
    }

	
	public void attack(Hare hare) {
		paint(hare);
	}
	
	public void paint(Hare hare) {
		hare.takeDamage(damage);
		System.out.println("Yiwen did " + damage + " damage on " + hare.getName());
	}
}