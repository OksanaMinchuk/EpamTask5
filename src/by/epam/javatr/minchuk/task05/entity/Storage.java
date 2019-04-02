package by.epam.javatr.minchuk.task05.entity;

import by.epam.javatr.minchuk.task05.util.ConstantConfigurator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Class {@code Storage}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Storage {

    private BlockingQueue<Container> containers;

    public Storage() {
        this.containers = new ArrayBlockingQueue<Container>(Integer.valueOf(ConstantConfigurator.DEFAULT_STORAGE_CAPACITY));
        for (int i = 0; i < containers.size(); i++) {
            this.containers.add(new Container());
        }
    }

    public Container removeContainer() throws InterruptedException {
        return this.containers.take();
    }

    public void addContainer(Container container) {
        try {
            this.containers.put(container);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
