import java.util.ArrayList;

public abstract class Healers extends Hero {
    int mana;

    public Healers(ArrayList<Hero> gang, String name, String role, int attack, int protection, int[] damage, int health, int speed, int mana, int x, int y) {
        super(gang, name, role, attack, protection, damage, health, speed, x, y);
        this.mana = mana;
    }

    @Override
    public void step(ArrayList<Hero> heroList) {
        double minHealth = 100;
        int minHealthHero = 0;
        for (int i = 0; i < gang.size(); i++) {
            int heroHealth = gang.get(i).getHealth();
            int heroMaxHealth = gang.get(i).getMaxHealth();
            if (heroHealth < heroMaxHealth){
                double temp = ((double)heroHealth / (double)heroMaxHealth) * 100;
                if (temp < minHealth) {
                    minHealth = temp;
                    minHealthHero = i;
                }
            }
        }
        // лечим героя с минимумом здоровья
        gang.get(minHealthHero).setHealth(gang.get(minHealthHero).getHealth()+1);
    }

    @Override
    public String toString() {
        return super.toString() + ", Mana: " + mana;
    }

}

