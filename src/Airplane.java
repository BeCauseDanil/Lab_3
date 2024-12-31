import java.util.Comparator;
import java.util.Objects;

/**
 * Клас Airplane представляє інформацію про літаки.
 * Містить модель, рік випуску, місткість, дальність польоту та виробника.
 */
public class Airplane implements Comparable<Airplane> {

    private String model; // Модель літака
    private int year; // Рік випуску
    private int capacity; // Місткість пасажирів
    private double range; // Дальність польоту (в кілометрах)
    private String manufacturer; // Виробник літака

    /**
     * Конструктор для створення об'єкта Airplane.
     *
     * @param model        Модель літака
     * @param year         Рік випуску
     * @param capacity     Місткість пасажирів
     * @param range        Дальність польоту (в кілометрах)
     * @param manufacturer Виробник літака
     */
    public Airplane(String model, int year, int capacity, double range, String manufacturer) {
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.range = range;
        this.manufacturer = manufacturer;
    }

    /**
     * Отримує модель літака.
     *
     * @return Модель літака
     */
    public String getModel() {
        return model;
    }

    /**
     * Встановлює модель літака.
     *
     * @param model Нова модель літака
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Отримує рік випуску літака.
     *
     * @return Рік випуску літака
     */
    public int getYear() {
        return year;
    }

    /**
     * Встановлює рік випуску літака.
     *
     * @param year Новий рік випуску
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Отримує місткість пасажирів.
     *
     * @return Місткість пасажирів
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Встановлює місткість пасажирів.
     *
     * @param capacity Нова місткість пасажирів
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Отримує дальність польоту літака.
     *
     * @return Дальність польоту (в кілометрах)
     */
    public double getRange() {
        return range;
    }

    /**
     * Встановлює дальність польоту літака.
     *
     * @param range Нова дальність польоту (в кілометрах)
     */
    public void setRange(double range) {
        this.range = range;
    }

    /**
     * Отримує виробника літака.
     *
     * @return Виробник літака
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Встановлює виробника літака.
     *
     * @param manufacturer Новий виробник літака
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Повертає текстове представлення об'єкта Airplane.
     *
     * @return Текстове представлення об'єкта
     */
    @Override
    public String toString() {
        return "Airplane{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", capacity=" + capacity +
                ", range=" + range +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    /**
     * Порівнює два об'єкти Airplane за роком випуску.
     *
     * @param other Об'єкт Airplane для порівняння
     * @return Результат порівняння за роком випуску
     */
    @Override
    public int compareTo(Airplane other) {
        return Integer.compare(this.year, other.year);
    }

    /**
     * Метод для сортування за місткістю (за зростанням) і дальністю (за спаданням).
     *
     * @return Компаратор для сортування
     */
    public static Comparator<Airplane> compareByCapacityAndRange() {
        return Comparator.comparingInt(Airplane::getCapacity) // За місткістю (за зростанням)
                .thenComparingDouble((Airplane a) -> -a.getRange()); // За дальністю (за спаданням)
    }

    /**
     * Перевіряє рівність двох об'єктів Airplane.
     *
     * @param obj Об'єкт для порівняння
     * @return true, якщо об'єкти однакові, інакше false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Airplane airplane = (Airplane) obj;
        return year == airplane.year &&
                capacity == airplane.capacity &&
                Double.compare(airplane.range, range) == 0 &&
                Objects.equals(model, airplane.model) &&
                Objects.equals(manufacturer, airplane.manufacturer);
    }

    /**
     * Повертає хеш-код для об'єкта Airplane.
     *
     * @return Хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(model, year, capacity, range, manufacturer);
    }
}
