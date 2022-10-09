package main.java;

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
