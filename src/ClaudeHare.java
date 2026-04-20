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
}