package BattleOfDroids.droids;

import java.util.Random;
/**
 * Клас, що представляє тип Droid'а
 * (Батьківський клас для усіх типів дроїдів)
 *
 * @author Yaromyr Kuspis
 */
public class Droid {
    protected String name;
    protected int health;
    protected int damage;

    /**
     * Конструктор з параметрами
     *
     * @param name   ім'я дроїда
     * @param health кількість HP дроїда
     * @param damage максимальний урон,що може нанести дроїд
     */
    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    /**
     * Геттер для поля name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер для поля health
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Метод для атаки ворожого дроїда.Повертає урон нанесений дроїдом.
     *
     * @return real damage
     */
    public int attack() {
        Random random = new Random();
        return random.nextInt(damage - 1) + 1;
    }

    /**
     * Метод для отримання урону дроїдом
     *
     * @param damage урон,що наніс ворожий дроїд
     * @return false or true
     */
    public boolean getHit(int damage) {
        this.health -= damage;
        if (health < 0) {
            health = 0;
            System.out.println(name + " was killed!");
        }
        return true;
    }

    /**
     * Перевантажений метод toString
     *
     * @return String
     */
    @Override
    public String toString() {
        return name + "\n(HP: " + health + " Max Damage: " + damage + ")";
    }
}
