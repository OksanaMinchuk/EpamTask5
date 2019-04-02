package by.epam.javatr.minchuk.task05.entity;

import by.epam.javatr.minchuk.task05.util.ConstantConfigurator;

import java.util.Random;

/**
 * Class {@code Container}
 *
 * @autor Oksana Minchuk
 * @version 1.0 31.03.2019
 */

public class Container {

    private int weight;

    public Container() {
        Random random = new Random();
        this.weight = Integer.valueOf(ConstantConfigurator.MIN_CONTAINER_WEIGHT)
                + random.nextInt(Integer.valueOf(ConstantConfigurator.MAX_CONTAINER_WEIGHT)
                - Integer.valueOf(ConstantConfigurator.MIN_CONTAINER_WEIGHT) + 1);
    }

    public int getWeight() {
        return weight;
    }
}
