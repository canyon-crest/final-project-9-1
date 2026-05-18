import students.*;
import hare.*;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game {

    private Student[][] students;
    private Hare[][] hares;
    private int spinach;
    private int rows;
    private int cols;
    private int tick;

    public Game(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        students = new Student[rows][cols];
        hares = new Hare[rows][cols];
        spinach = 100;
        tick = 0;
    }

    public boolean placeStudent(Student s, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        if (students[row][col] != null) {
            return false;
        }

        if (spinach < s.getCost()) {
            return false;
        }

        students[row][col] = s;
        spinach -= s.getCost();
        return true;
    }

    public void spawnHare(int row) {
    	Hare h;
    	int random = (int)(Math.random()*100);
    	if (random < 7) {
    		h = new PinkHare(row);
    	}
    	else if (random < 17) {
    		h = new ClaudeHare(row);
    	}
    	else if (random < 27) {
    		h = new BuffHare(row);
    	}
    	else {
    		h = new RegularHare(row);
    	}
    	
        hares[row][9] = h;
    }

    public void gameTick() {
        tick++;
        System.out.println("\nTick: " + tick);

        // Example: spawn a hare every 3 ticks
        if (tick % 3 == 0) {
            int randomRow = (int)(Math.random() * rows);
            spawnHare(randomRow);
            System.out.println("A Hare spawned in row " + randomRow);
        }

        // Students act
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Student s = students[r][c];
                if (s != null) {
                    s.act(hares);
                }
            }
        }

        // Change hares
        for (int i = 0; i < hares.length; i++) {
        	for (int j = 0; j < hares[0].length; j++) {
        		
        		if (hares[i][j] != null) {
        			Hare h = hares[i][j];
                    
        	        // Move hares
                    if (students[i][j] != null) {
                    	h.attack();
                    }
                    else {
                    	h.move();
                    	hares[i][j] = null;
                    	hares[i][j-1] = h;
                        System.out.println("Hare in row " + i + " moved to col " + j);
                    }
                    
                    // Remove dead hares & dead students
                    if (hares[i][j].getHealth() == 0) {
                        hares[i][j] = null;
                        System.out.println("A Hare was defeated.");
                    }
        		}
        	}  
        }
        
        // Change students
        for (int i = 0; i < students.length; i++) {
        	for (int j = 0; j<students[0].length; j++)
	            if (students[i][j] != null && students[i][j].getHealth() == 0) {
	                System.out.println("A " + students[i][j].getName() + " was defeated.");
	                students[i][j] = null;
	            }
        }

        // Print spinach
        System.out.println("Spinach: " + spinach);
        
<<<<<<< HEAD
//        for (int i = 0; i<rows; i++) {
//        	for (int j = 0; j<cols; j++) {
//        		if (students[i][j] != null) {
//        			System.out.print("S");
//        		}
//        		else if (hares[i][j] != null) {
//        			System.out.print("H");
//        		}
//        		System.out.print("*");
//        	}
//        }
//        }
=======
        for (int i = 0; i<rows; i++) {
        	for (int j = 0; j<cols; j++) {
        		if (students[i][j] != null) {
        			System.out.print("S");
        		}
        		else if (hares[i][j] != null) {
        			System.out.print("H");
        		}
        		System.out.print("*");
        	}
        }
>>>>>>> a26bf44fd7f52e0679077e9967ec1d9a6e1cfec2
    }

    public void start() {
        while (true) {
            gameTick();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Game game = new Game(5, 9);

        JFrame frame = new JFrame("Student vs Hares");

        GamePanel panel = new GamePanel("/images/background.png", game);

        frame.add(panel);
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Game loop
        while (true) {

            game.gameTick();

            panel.repaint();

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}