package lab1.main.java.impl;

import lab1.main.java.AbstractFactory;

public class FactoryCreator {
    public AbstractFactory createFactory(String type) {
        if (type.equals("Dev")) {
            return new DeveloperFactory();
        } else if (type.equals("Simulation")) {
            return new SimulationFactory();
        }
        return null;
    }
}
