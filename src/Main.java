package BattleOfDroids;

import BattleOfDroids.Battle.Battle;
import BattleOfDroids.Printer.Printer;
import BattleOfDroids.Team.Team;

import java.util.Scanner;

/**
 * Main клас для створення екземплярів класів
 *
 * @author Yaromyr Kuspis
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * main метод
     *
     * @param args масив параметрів командного рядка
     */
    public static void main(String[] args) {
        String value;
        do {
            System.out.println("1.1v1");
            System.out.println("2.5v5");
            System.out.println("3.Read battle from file");
            System.out.println("4.Exit\n");
            System.out.print("Your choice: ");
            value = scanner.nextLine();
            switch (value) {
                case "1" -> startBattle(1);
                case "2" -> {
                    startBattle(5);
                }
                case "3" -> {
                    System.out.println("Enter the file path:");
                    String fileName = scanner.nextLine();
                    Printer.readFromFile(fileName);
                }
                case "4" -> System.out.println("Bye, see you soon<3");
            }

        } while (!value.equals("4"));

    }

    /**
     * Метод,що викликає метод start Main класу
     *
     * @param size розмір команд дроїдів
     */
    private static void startBattle(int size) {
        Printer pr = null;
        System.out.println("Write the result of fight to file? Yes/No: ");
        if (scanner.nextLine().toLowerCase().equals("yes")) {
            pr = new Printer("ResOfFight.txt");
            Printer.writeToFile = true;
        } else {
            Printer.writeToFile = false;
        }
        start(size);
        if (Printer.writeToFile == true && pr != null) {
            pr.closePrinter();
        }
    }

    /**
     * Метод для формування команд та запуску битви між ними
     *
     * @param size розмір команд дроїдів
     */
    private static void start(int size) {
        Printer.print("\nFormation of the first team");
        Team myTeam = new Team(size);
        Printer.print("\nFormation of the second team");
        Team enemyTeam = new Team(size);

        Battle battle = new Battle(myTeam, enemyTeam);
        battle.startFight();
    }
}
