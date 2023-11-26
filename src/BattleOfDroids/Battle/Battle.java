package BattleOfDroids.Battle;

import BattleOfDroids.Printer.Printer;
import BattleOfDroids.droids.Droid;
import BattleOfDroids.Team.Team;

import java.util.Random;

/**
 * Клас для представлення поля бою Дроїдів
 *
 * @author Yaromyr Kuspis
 */
public class Battle {

    protected Team firstTeam;
    protected Team secondTeam;
    private int currentRound = 1;
    private Random random;

    /**
     * Конструктор з параметрами
     *
     * @param firstTeam  перша команда
     * @param secondTeam друга команда
     */
    public Battle(Team firstTeam, Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        random = new Random();
    }

    /**
     * Метод для запуску бою між дроїдами
     */
    public void startFight() {
        battle();
    }

    /**
     * Метод який реалізує атаку дроїдів один на одного
     *
     * @param first            перша команда
     * @param second           друга команда
     * @param firstDroidIndex  індекс дроїда із першої команди який буде атакувати
     */
    private void fight(Team first, Team second, int firstDroidIndex) {
        if (!first.getDroidList().isEmpty()) {
            int index = random.nextInt((second.getDroidList().size())) + 1;
            Droid firstDroid = first.getDroidList().get(firstDroidIndex);
            Droid secondDroid = second.getDroidList().get(index - 1);
            int damage = firstDroid.attack();
            boolean isDamaged = secondDroid.getHit(damage);

            if (isDamaged) {
                Printer.print(first.getDroidList().get(firstDroidIndex).getName() + " gives " + damage + " damage to " + secondDroid.getName());
            }

            if (second.getDroidList().get(index - 1).getHealth() <= 0) {
                second.getDroidList().remove(index - 1);
            }
        } else Printer.print("Whole team is destroyed\n");

    }

    /**
     * Метод,що реалізує бій між командами дроїдів
     */
    private void battle() {
        int myDroidIndex = 0;
        int enemyDroidIndex = 0;
        while (!firstTeam.getDroidList().isEmpty() && !secondTeam.getDroidList().isEmpty()) {
            Printer.print("\n----------------------------Round №" + currentRound++ + "----------------------------");

            Printer.print("First team turn:");
            fight(firstTeam, secondTeam, myDroidIndex);
            Printer.print("\nSecond team turn:");
            fight(secondTeam, firstTeam, enemyDroidIndex);
            showInfo();

            myDroidIndex++;
            enemyDroidIndex++;

            if (myDroidIndex >= firstTeam.getDroidList().size() - 1) {
                myDroidIndex = 0;
            }

            if (enemyDroidIndex >= secondTeam.getDroidList().size() - 1) {
                enemyDroidIndex = 0;
            }

        }
        if (firstTeam.getDroidList().isEmpty()) {
            Printer.print("\nSecond team wins\n");
        } else {
            Printer.print("\nFirst team wins\n");
        }
    }

    /**
     * Метод який викликає printList для виводу двох команд
     */
    private void showInfo() {
        Printer.print("\nFirst team:");
        printList(firstTeam);

        Printer.print("\nSecond team:");
        printList(secondTeam);
    }

    /**
     * Метод для виводу на екран команди,що передається як параметр
     *
     * @param team команда,що передається у метод
     */
    private void printList(Team team) {
        if (team.getDroidList().isEmpty()) {
            Printer.print("Destroyed");
        }

        for (int i = 0; i < team.getDroidList().size(); i++) {
            Printer.print(team.getDroidList().get(i).toString());
        }
    }
}
