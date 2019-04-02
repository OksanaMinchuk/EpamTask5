package by.epam.javatr.minchuk.task05.util;

import java.util.ResourceBundle;

public class ConstantConfigurator {

    private static ResourceBundle bundle;

    static {
        createConstant();
    }

    public ConstantConfigurator() {
    }

    public static String DEFAULT_STORAGE_CAPACITY;
    public static String MAX_CONTAINER_WEIGHT;
    public static String MIN_CONTAINER_WEIGHT;
    public static String COUNT_DOCKS;
    public static String COUNT_SHIPS;

    public static void createConstant() {

        bundle = ResourceBundle.getBundle("config");

        DEFAULT_STORAGE_CAPACITY = bundle.getString("DEFAULT_STORAGE_CAPACITY");
        MAX_CONTAINER_WEIGHT = bundle.getString("MAX_CONTAINER_WEIGHT");
        MIN_CONTAINER_WEIGHT = bundle.getString("MIN_CONTAINER_WEIGHT");
        COUNT_DOCKS = bundle.getString("COUNT_DOCKS");
        COUNT_SHIPS = bundle.getString("COUNT_SHIPS");

    }

}
