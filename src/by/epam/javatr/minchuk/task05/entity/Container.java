package by.epam.javatr.minchuk.task05.entity;

import java.util.Objects;

/**
 * Class {@code Container}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Container {

    public Container() {
    }

    private int registrationNumber;

    public Container(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }
}
