package student;
import hare.Hare;

public class Jennifer extends Student{
	
	private int damage;
	private int range;
	
	public Jennifer(int cost, int health, int cooldown, int damage, int range) {
	    super("Jennifer", cost, health, cooldown);
	    this.damage = damage;
	    this.range = range;
	}
	
	public void act(Hare hare) {
		sing(hare);
	}
	
	public void sing(Hare hare) {
		hare.setHealth(hare.getHealth - damage);
		System.out.println("Jennifer did " + damage + " damage on " + hare.getName());
	}
}