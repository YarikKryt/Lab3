package BattleOfDroids.Team;

import BattleOfDroids.Printer.Printer;
import BattleOfDroids.droids.Attacker;
import BattleOfDroids.droids.Defender;
import BattleOfDroids.droids.Droid;
import BattleOfDroids.droids.Healer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Клас для представлення команди дроїдів
 */
public class Team {
    private final List<Droid> droids = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Конструктор з параметром
     *
     * @param size кількість дроїдів у команді
     */
    public Team(int size) {
        fillTeam(size);
    }

    /**
     * Геттер для поля droids
     *
     * @return droids
     */
    public List<Droid> getDroidList() {
        return droids;
    }

    /**
     * Метод для заповнення команди дроїдами
     *
     * @param size кількість дроїдів у команді
     */
    public void fillTeam(int size) {
        for (int i = 0; i < size; i++) {
            Printer.print("Choose droid №" + (i + 1));
            try {
                droids.add(chooseDroid());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод для вибору дроїда
     *
     * @return droid - екземпляр дроїда
     * @throws IOException виняток,що може виникнути при вводі
     */
    private Droid chooseDroid() throws IOException {
        Printer.print("1. Healer\n2. Attack Droid\n3. Defender ");
        Droid droid;
        System.out.print("Your choice: ");
        String value = scanner.nextLine();

        while (!value.equals("1") && !value.equals("2") && !value.equals("3")) {
            Printer.print("Wrong input");
            value = scanner.nextLine();
        }

        droid = switch (value) {
            case "1" -> new Healer();
            case "2" -> new Attacker();
            default -> new Defender();
        };

        Printer.printInputValue("Your choice: " + value);
        return droid;
    }
}
