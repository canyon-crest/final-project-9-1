package powerup;
public class Outage {

    private int duration;

    public Outage(int duration) {
        this.duration = duration;
    }

    public void apply(Game g) {
        for (Hare h : g.getHares()) {
            h.freeze(duration);
        }
    }
}