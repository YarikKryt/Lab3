package BattleOfDroids.droids;

import java.util.Random;

/**
 * Клас,що представляє тип Defend дроїда
 *
 * @author Yaromyr Kuspis
 */
public class Defender extends Droid {
    protected final int chanceToDodge;

    /**
     * Конструктор без параметрів, що визиває конструктор у батьківського класу
     */
    public Defender() {
        super("Defender ", 150, 10);
        this.chanceToDodge = 20;
    }

    @Override
    public int attack() {
        Random random = new Random();
        return random.nextInt(damage - 5) + 5;
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
        if (random.nextInt(100) > chanceToDodge) {
            this.health -= damage;
            if (health < 0) {
                health = 0;
                System.out.println(name + " was killed!");
            }
            return true;
        } else {
            System.out.println("Defender blocked the attack");
            return false;
        }
    }
}
