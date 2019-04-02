package by.epam.javatr.minchuk.task05.controller;

import by.epam.javatr.minchuk.task05.entity.Port;
import by.epam.javatr.minchuk.task05.entity.Ship;
import by.epam.javatr.minchuk.task05.entity.Storage;
import by.epam.javatr.minchuk.task05.util.DockCreator;
import by.epam.javatr.minchuk.task05.util.ShipCreator;

/**
 * Class {@code MainController}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class MainController {

    public static void main(String[] args) {

       Port port = new Port(new Storage(), DockCreator.createDocksList());

       Ship[] ships = ShipCreator.createShips(port);

       for (Ship ship: ships) {
           try {
               ship.getThread().join();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

    }

}
