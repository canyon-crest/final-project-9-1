public class Bulletin {

    private double multiplier;

    public Bulletin(double multiplier) {
        this.multiplier = multiplier;
    }

    public void apply(Game g, String type) {
        for (Student s : g.getStudents()) {

            if (type.equalsIgnoreCase("Yiwen") && s instanceof Yiwen) {
                s.buff(multiplier);

            } else if (type.equalsIgnoreCase("Kate") && s instanceof Kate) {
                s.buff(multiplier);

            } else if (type.equalsIgnoreCase("Jennifer") && s instanceof Jennifer) {
                s.buff(multiplier);
            }

            // Afina intentionally excluded
        }
    }
}