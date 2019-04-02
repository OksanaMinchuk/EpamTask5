package by.epam.javatr.minchuk.task05.util;

import by.epam.javatr.minchuk.task05.entity.Dock;
import by.epam.javatr.minchuk.task05.entity.Port;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class {@code DockCreator}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class DockCreator {

    public static Queue<Dock> createDocksList() {
        Queue<Dock> docksList = new LinkedList<>();
        for (int i = 0; i < Integer.valueOf(ConstantConfigurator.COUNT_DOCKS); i++) {
            docksList.add(new Dock(i));
        }
        return docksList;
    }
}


