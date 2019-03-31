package by.epam.javatr.minchuk.task05.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code Ship}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Ship implements Runnable {

    private int id;
    private List<Container> currentContainers;
    private int maxNumberOfContainers;;
    private Port port;

    public Ship() {
    }

    public Ship(int id, int numberOfContainers, int maxNumberOfContainers) {
        this.id = id;
        this.currentContainers = new ArrayList<>(numberOfContainers);
        this.maxNumberOfContainers = maxNumberOfContainers;
    }

    @Override
    public void run() {

    }
}
