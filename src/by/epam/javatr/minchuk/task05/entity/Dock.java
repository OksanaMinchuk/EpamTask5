package by.epam.javatr.minchuk.task05.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class {@code Dock}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Dock {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    private int id;

    public Dock(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void dockTaken(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
            LOGGER.info("Dock id = " + getId() + " is taken.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.error("error ", e);
        }
    }

    @Override
    public String toString() {
        return "Dock{" +
                "id=" + id +
                '}';
    }
}
