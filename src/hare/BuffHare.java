package hare;
public class BuffHare extends Hare{
	public BuffHare(int row) {
		super(200,0.8,row);
	}
	
	@Override
	public void takeDamage(int dmg) {
		super.takeDamage(dmg/2);
	}
}