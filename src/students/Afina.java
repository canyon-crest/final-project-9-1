package students;

import hare.Hare;
import spinach.*;

import java.util.ArrayList;

public class Afina extends Student {
    private static int count;
    private static int time;
    
    public Afina(int row, int col) {
        // Name, Cost, Health, Cooldown (ticks between production), Row, Col
        super("Afina", 50, 100, 100, row, col);
        count++;
    }

    public static int getCount() {
    	return count;
    }
    
    
    @Override
    public void attack(Hare hare) {
        // Afina is a lover, not a fighter!
    }

}
