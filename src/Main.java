import java.util.Arrays;
import java.util.Comparator;

/**
 * Основний клас для роботи з масивом об'єктів Airplane.
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Створення масиву об'єктів Airplane
        Airplane[] airplaneArray = {
                new Airplane("Boeing 747", 1995, 660, 14815, "Boeing"),
                new Airplane("Airbus A380", 2005, 853, 15200, "Airbus"),
                new Airplane("Concorde", 1976, 100, 7222, "Aerospatiale"),
                new Airplane("Il-96", 1993, 262, 11000, "Ilyushin"),
                new Airplane("Tu-154", 1968, 180, 5200, "Tupolev")
        };

        // Сортування масиву за роком випуску (за зростанням)
        Arrays.sort(airplaneArray, Comparator.comparingInt(Airplane::getYear));

        // Виведення масиву після сортування за роком випуску
        System.out.println("Масив літаків, відсортований за роком випуску (за зростанням):");
        for (Airplane airplane : airplaneArray) {
            System.out.println(airplane);
        }

        // Сортування масиву за місткістю (за зростанням) і дальністю (за спаданням)
        Arrays.sort(airplaneArray, Comparator.comparingInt(Airplane::getCapacity).thenComparingDouble(a -> -a.getRange()));

        // Виведення масиву після сортування за місткістю і дальністю
        System.out.println("\nМасив літаків, відсортований за місткістю і дальністю:");
        for (Airplane airplane : airplaneArray) {
            System.out.println(airplane);
        }

        // Заданий об'єкт для пошуку
        Airplane targetAirplane = new Airplane("Concorde", 1976, 100, 7222, "Aerospatiale");

        // Пошук об'єкта, ідентичного заданому
        Airplane foundAirplane = findAirplane(airplaneArray, targetAirplane);

        // Результат пошуку
        if (foundAirplane != null) {
            System.out.println("\nЗнайдений об'єкт: " + foundAirplane);
        } else {
            System.out.println("\nОб'єкт не знайдено.");
        }
    }

    /**
     * Знаходить об'єкт у масиві, який ідентичний заданому об'єкту.
     *
     * @param airplaneArray Масив об'єктів Airplane.
     * @param targetAirplane Об'єкт для пошуку.
     * @return Знайдений об'єкт або null, якщо об'єкт не знайдено.
     */
    public static Airplane findAirplane(Airplane[] airplaneArray, Airplane targetAirplane) {
        for (Airplane airplane : airplaneArray) {
            if (airplane.equals(targetAirplane)) {
                return airplane;
            }
        }
        return null;
    }
}
