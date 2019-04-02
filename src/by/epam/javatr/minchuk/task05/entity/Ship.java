package by.epam.javatr.minchuk.task05.entity;

import by.epam.javatr.minchuk.task05.exception.PortResourseExceptoin;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class {@code Ship}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Ship implements Runnable {

    private static final int WAITING_TIME = 2000;
    private static final int TAKING_TIME = 1000;
    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

    private int id;
    private int currentNumberOfContainers;
    private int maxNumberOfContainers;
    private Port port;

    private List<Container> shipContainerList;

    private Thread thread;
    private boolean reading = false;

    public int getId() {
        return id;
    }

    public int getCurrentNumberOfContainers() {
        return currentNumberOfContainers;
    }

    public int getMaxNumberOfContainers() {
        return maxNumberOfContainers;
    }

    public Thread getThread() {
        return thread;
    }

    public List<Container> getShipContainerList() {
        return shipContainerList;
    }

    public void setShipContainerList(List<Container> shipContainerList) {
        this.shipContainerList = shipContainerList;
    }

    public Ship(int id, int currentNumberOfContainers, int maxNumberOfContainers, Port port) {
        this.id = id;
        this.shipContainerList = new ArrayList<>();
        for (int i = 0; i < currentNumberOfContainers; i++) {
            this.shipContainerList.add(new Container());
        }
        this.maxNumberOfContainers = maxNumberOfContainers;
        this.port = port;
        thread = new Thread(this);
        thread.start();
    }



    @Override
    public void run() {
        Dock dock = null;
        try {
            dock = port.getResourseDock(WAITING_TIME);
            if (dock != null) {
                reading = true;
                LOGGER.info("Ship #" + thread.getId() + " get to dock #" + dock.getId());
                dock.dockTaken(TAKING_TIME);
            } else {
                LOGGER.info("Time is over. Ship #" + thread.getId() + " go out");
            }
//        } catch (PortResourseExceptoin portResourseExceptoin) {
//            portResourseExceptoin.printStackTrace();
//            LOGGER.error(portResourseExceptoin);
        } finally {
            if (dock != null) {
                reading = false;
                LOGGER.info("Ship #" + thread.getId() + " : " + dock.getId() + "dock release");
                port.returnResourseDock(dock);
            }
        }

    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", shipContainerList=" + shipContainerList +
                ", maxNumberOfContainers=" + maxNumberOfContainers +
                ", port=" + port +
                '}';
    }

}
