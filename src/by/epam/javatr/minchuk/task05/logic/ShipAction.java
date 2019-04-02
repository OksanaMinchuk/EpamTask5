package by.epam.javatr.minchuk.task05.logic;

import by.epam.javatr.minchuk.task05.entity.Container;
import by.epam.javatr.minchuk.task05.entity.Port;
import by.epam.javatr.minchuk.task05.entity.Ship;
import org.apache.log4j.Logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShipAction {

    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    private static Lock lock;

    static {
        lock = new ReentrantLock();
    }

    public static void loadingShip (Port port, Ship ship) {
        lock.lock();
        try {
            int count = ship.getCurrentNumberOfContainers();
            while (count != ship.getMaxNumberOfContainers()) {
                Container temp = port.getStorage().removeContainer();
                ship.getShipContainerList().add(temp);
                count++;
                LOGGER.info("Ship # " + ship.getId() + " loading...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            LOGGER.error(e);
        } finally {
            lock.unlock();
        }
    }
    public static void unloadingShip (Port port, Ship ship) {
        lock.lock();
        try {
            int count = ship.getCurrentNumberOfContainers();
            while (count != 0) {
                Container temp = ship.getShipContainerList().remove(count);
                port.getStorage().addContainer(temp);
                count--;
                LOGGER.info("Ship # " + ship.getId() + " unloading...");
            }
        } finally {
            lock.unlock();
        }
    }
}
