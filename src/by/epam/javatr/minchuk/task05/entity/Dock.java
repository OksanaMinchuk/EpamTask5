package by.epam.javatr.minchuk.task05.entity;

/**
 * Class {@code Dock}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Dock {

    private int id;
    private int currentNumberContainers;

    private static final int DEFAULT_MAX_CAPACITY = 10_000;

    public Dock(int id, int currentNumberContainers) {
        this.id = id;
        this.currentNumberContainers = currentNumberContainers;
    }

    public int getCurrentNumberContainers() {
        return currentNumberContainers;
    }

    public boolean addContainers(int containers) {
        boolean result = true;
        if (currentNumberContainers + containers > DEFAULT_MAX_CAPACITY) {
            result = false;
        }
        currentNumberContainers += containers;
        return result;
    }

    public boolean removeContainers(int containers) {
        boolean result = true;
        if (currentNumberContainers - containers < 0) {
            result = false;
        }
        currentNumberContainers -= containers;
        return result;
    }

    @Override
    public String toString() {
        return "Dock{" +
                "id=" + id +
                ", currentNumberContainers=" + currentNumberContainers +
                ", maxCapacity=" + DEFAULT_MAX_CAPACITY +
                '}';
    }
}
