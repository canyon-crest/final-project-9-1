public class PowerUp {

    private int outageCost;
    private int foodCost;
    private int bulletinCost;

    private int wavesSinceBulletin;

    public PowerUp(int outageCost, int foodCost, int bulletinCost) {
        this.outageCost = outageCost;
        this.foodCost = foodCost;
        this.bulletinCost = bulletinCost;
        this.wavesSinceBulletin = 3; // allow immediate use
    }

    public void nextWave() {
        wavesSinceBulletin++;
    }

    // 🔹 Claude AI Outage
    public void useOutage(Game g) {
        if (g.getSpinachCount() < outageCost) return;

        g.spendSpinach(outageCost);

        Outage effect = new Outage(5);
        effect.apply(g);
    }

    // 🔹 Food in Classroom
    public void useFood(Game g, int row) {
        if (g.getSpinachCount() < foodCost) return;

        g.spendSpinach(foodCost);

        FoodAttack effect = new FoodAttack(100);
        effect.apply(g, row);
    }

    // 🔹 Weekly Bulletin
    public void useBulletin(Game g, String studentType) {
        if (g.getSpinachCount() < bulletinCost) return;
        if (wavesSinceBulletin < 3) return;

        g.spendSpinach(bulletinCost);
        wavesSinceBulletin = 0;

        Bulletin effect = new Bulletin(1.5);
        effect.apply(g, studentType);
    }
}