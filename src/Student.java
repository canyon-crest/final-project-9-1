
import java.util.*;

public abstract class Student{
	protected String name;
	protected int cost;
	protected int health;
	protected int cd;
	
	public abstract void act();
	
	public void takeDamage(int damage) {
		health -= damage;
	};
}