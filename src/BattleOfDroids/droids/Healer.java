package BattleOfDroids.droids;

import java.util.Random;
/**
 * Клас,що представляє тип Heal дроїда
 *
 * @author Yaromyr Kuspis
 */
public class Healer extends Droid {
    private final int chanceToHeal;
    private final int healHp;

    /**
     * Конструктор без параметрів,що визиває конструктор у батьківського класу
     */
    public Healer() {
        super("Healer", 100, 15);
        this.chanceToHeal = 15;
        this.healHp = 15;
    }

    @Override
    public int attack() {
        return damage;
    }

    /**
     * Метод для отримання урону дроїдом
     *
     * @param damage урон,що наніс ворожий дроїд
     * @return false or true
     */
    @Override
    public boolean getHit(int damage) {
        Random random = new Random();
        this.health -= damage;
        if (random.nextInt(100) < chanceToHeal) {
            this.health += random.nextInt(healHp - 10) + 10;
            System.out.println("Healer recovered " + healHp + " HP");
        }
        if (health < 0) {
            health = 0;
            System.out.println(name + " was killed!");
        }
        return true;
    }

}
