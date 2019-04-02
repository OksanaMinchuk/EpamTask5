package by.epam.javatr.minchuk.task05.entity;

import by.epam.javatr.minchuk.task05.exception.PortResourseExceptoin;
import by.epam.javatr.minchuk.task05.util.ConstantConfigurator;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class {@code Port}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Port {

    private static final Logger LOGGER;

    private static Lock lock;

    static {
        LOGGER = Logger.getRootLogger();
        lock = new ReentrantLock();
    }

    private Semaphore semaphore;
    private static Storage storage;
    private static Queue<Dock> dockList;

    public Port(Storage storage, Queue<Dock> dockList) {
        this.semaphore = new Semaphore(Integer.valueOf(ConstantConfigurator.COUNT_DOCKS), true);
        this.storage = storage;
        this.dockList = new LinkedList<>();
        this.dockList.addAll(dockList);
    }

    public Dock getResourseDock(long maxWaitMillis) {//throws PortResourseExceptoin {
        Dock currentDock = null;
        try {
            if (semaphore.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS)) {
                currentDock = dockList.poll();
                return currentDock;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentDock;
       // throw new PortResourseExceptoin("timeout exceeded");
    }

    public void returnResourseDock(Dock dock) {
        dockList.add(dock);
    }

    public static Storage getStorage() {
        return storage;
    }

    public static void setStorage(Storage storage) {
        Port.storage = storage;
    }

    public static Queue<Dock> getDockList() {
        return dockList;
    }

    public static void setDockList(Queue<Dock> dockList) {
        Port.dockList.addAll(dockList);
    }
}
