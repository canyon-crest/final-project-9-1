package students;
import hare.Hare;
import java.util.*;

public class Jennifer extends Student{
	
	private int damage;
	
	public Jennifer(int cost, int health, int cooldown, int damage, int range, int row, int col) {
	    super("Jennifer", cost, health, cooldown, row, col);
	    this.damage = damage;
	}
	
	public void attack(Hare hare) {
		sing(hare);
	}
	
	public void sing(Hare hare) {
		hare.takeDamage(damage);
		System.out.println("Jennifer did " + damage + " damage on " + hare.getName());
	}
}