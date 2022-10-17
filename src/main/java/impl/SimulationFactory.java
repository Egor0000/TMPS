package main.java.impl;

import main.java.AbstractFactory;
import main.java.Simulation;

public class SimulationFactory implements AbstractFactory<Simulation> {
    @Override
    public Simulation create(String name) {
        if (name.equals("Board")) {
            return new Board();
        } else if (name.equals("Management")) {
            return new ManagementBoard();
        }
        return null;
    }
}
