package by.epam.javatr.minchuk.task05.entity;

import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
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
    private static final int COUNT_DOCKS = 3;

    private static Lock lock;
    private static Port instance;

    private Storage storage;
    private Semaphore semaphore;

    static {
        LOGGER = Logger.getRootLogger();
        lock = new ReentrantLock();
    }

    private Port() {
        this.semaphore = new Semaphore(COUNT_DOCKS);
    }

    public static Port getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new Port();
            }
            return instance;
        } finally {
            lock.unlock();
        }
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
}
