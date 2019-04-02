package by.epam.javatr.minchuk.task05.util;

import by.epam.javatr.minchuk.task05.entity.Port;
import by.epam.javatr.minchuk.task05.entity.Ship;

import java.util.Random;

public class ShipCreator{

    private static final int MAX_CURRENT_CONTAINERS = 5;
    private static final int MAX_SHIP_CONTAINERS = 10;
    private static final int MIN_SHIP_CONTAINERS = 5;

    public static Ship[] createShips(Port port) {

        Ship[] ships = new Ship[Integer.valueOf(ConstantConfigurator.COUNT_SHIPS)];
        Random random = new Random();
        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship(i, random.nextInt(MAX_CURRENT_CONTAINERS),
                    (MIN_SHIP_CONTAINERS + random.nextInt(MAX_SHIP_CONTAINERS)), port);
        }
        return ships;
    }
}
