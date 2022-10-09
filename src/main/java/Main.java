package main.java;

public class Main {
    public static void main(String[] args) throws Exception {

        Simulation simulation = (Simulation) new FactoryCreator().createFactory("Simulation").create("Board");

        simulation.startSimulation();
    }
}
