import students.*;
import hare.*;
import java.util.ArrayList;

public class Game {

    private Student[][] board;
    private ArrayList<Hare> hares;
    private int spinach;
    private int rows;
    private int cols;
    private int tick;

    public Game(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new Student[rows][cols];
        hares = new ArrayList<Hare>();
        spinach = 100;
        tick = 0;
    }

    public boolean placeStudent(Student s, int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        }

        if (board[row][col] != null) {
            return false;
        }

        if (spinach < s.getCost()) {
            return false;
        }

        board[row][col] = s;
        spinach -= s.getCost();
        return true;
    }

    public void spawnHare(int row) {
        hares.add(new Hare(row, cols - 1, 100));
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
                Student s = board[r][c];
                if (s != null) {
                    s.act(hares);
                }
            }
        }

        // Move hares
        for (int i = 0; i < hares.size(); i++) {
            Hare h = hares.get(i);
            
            if (board[h.getRow()][h.getCol()] != null) {
            	h.attack();
            }
            else {
            	h.move();
                System.out.println("Hare in row " + h.getRow() + " moved to col " + h.getCol());
            }
            
        }

        // Remove dead hares
        for (int i = hares.size() - 1; i >= 0; i--) {
            if (!hares.get(i).isAlive()) {
                hares.remove(i);
                System.out.println("A Hare was defeated.");
            }
        }

        // Print spinach
        System.out.println("Spinach: " + spinach);
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

        game.placeStudent(new Jennifer(), 0, 1);
        game.placeStudent(new Afina(), 2, 2);

        game.start();
    }
}