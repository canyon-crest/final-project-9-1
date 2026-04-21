package hare;
import GameManager;

public class ClaudeHare extends Hare{
	public ClaudeHare(int row) {
		super(120,1.0,row);
		applyHack();
	}
	
	private void applyHack() {
		GameManager.increaseSpinachSlowdown(0.25);
	}
	
	@Override 
	public void die() {
		GameManager.removeSpinachSlowdown(0.25);
		super.die();
	}
	
	static double spinachSlowdown = 0;

	public void increaseSpinachSlowdown(double amt) {
		spinachSlowdown += amt;
	}

	public void removeSpinachSlowdown(double amt) {
		spinachSlowdown -= amt;
	}
}