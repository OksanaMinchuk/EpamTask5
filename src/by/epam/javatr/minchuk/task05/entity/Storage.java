package by.epam.javatr.minchuk.task05.entity;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class {@code Storage}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Storage {

    private static final int DEFAULT_STORAGE_CAPASITY = 10_000;

    private Queue<Container> containers = null;

    public Storage() {
        this.containers = new LinkedBlockingQueue<>(DEFAULT_STORAGE_CAPASITY);
    }

    public Container removeContainer() {
        return containers.poll();
    }

    public boolean addContainer(Container container) {
        return this.containers.add(container);
    }
}
