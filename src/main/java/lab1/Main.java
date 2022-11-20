package lab1;

import lab1.main.java.Simulation;
import lab1.main.java.impl.FactoryCreator;

public class Main {
    public static void main(String[] args) throws Exception {

        Simulation simulation = (Simulation) new FactoryCreator().createFactory("Simulation").create("Board");

        simulation.startSimulation();
    }
}
