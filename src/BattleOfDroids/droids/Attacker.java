package BattleOfDroids.droids;

import java.util.Random;

/**
 * Клас,що представляє тип Attack дроїда
 *
 * @author Yaromyr Kuspis
 */
public class Attacker extends Droid {
    private final int chanceOfCritical;
    private final int criticalAttack;

    /**
     * Конструктор без параметрів,що визиває конструктор у батьківського класу
     */
    public Attacker() {
        super("Attack Droid", 50, 50);
        criticalAttack = 80;
        chanceOfCritical = 20;
    }

    /**
     * Метод для атаки ворожого дроїда.Повертає урон нанесений дроїдом.
     *
     * @return real damage or criticalAttack
     */
    @Override
    public int attack() {
        Random random = new Random();
        if (random.nextInt(100) > chanceOfCritical) return random.nextInt(damage - 20) + 20;
        else {
            System.out.println("Critical attack!");
            return criticalAttack;
        }
    }

}
