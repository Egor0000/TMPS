package lab2.main.java;

public class Kitchen {
    private boolean opened;
    private static Kitchen instance;

    private Kitchen() {

    }

    public static Kitchen getInstance() {
        if (instance == null) {
            instance = new Kitchen();
        }

        return instance;
    }

    public void open() {
        this.opened = true;
        System.out.println("Opened kitchen");
    }

    public void close() {
        this.opened = false;
        System.out.println("Closed kitchen");
    }

    public void prepare(Order order) {
        System.out.println("Perpared food with id " + order.getId());
    }
}
