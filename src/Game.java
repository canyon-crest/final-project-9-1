import hare.*;
import students.*;

public class Game {

    public static void main(String[] args) {

        Hare hare = new Hare(100);
        Jennifer jennifer = new Jennifer();
        Afina afina = new Afina();

        int tick = 0;

        System.out.println("Game started!");

        while (hare.getHealth() > 0) {
            tick++;
            System.out.println("\nTick: " + tick);

            // Hare moves every 2 ticks
            if (tick % 2 == 0) {
                System.out.println("Mr. Hare moves forward one square.");
            }

            // Jennifer attacks every 3 ticks
            if (tick % 3 == 0) {
                jennifer.sing(hare);
                System.out.println("Hare health: " + hare.getHealth());
            }

            // Afina generates spinach every 4 ticks
            if (tick % 4 == 0) {
                afina.act();
            }

            // stop if Hare dies
            if (hare.getHealth() <= 0) {
                System.out.println("Mr. Hare was defeated!");
                break;
            }

            // wait 1 second before next tick
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game over.");
    }
}