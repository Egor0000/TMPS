package lab2.main.java;

import lab2.main.java.foods.Food;

public class RestaurantHall {
    private boolean opened;
    private Kitchen kitchen = Kitchen.getInstance();
    private Long nextId = 0L;

    public void open() {
        this.opened = true;
        System.out.println("Opened restaurant hall");
    }

    public void close() {
        this.opened = false;
        System.out.println("Closed restaurant hall");
    }

    public Order order(Food food) {
        Order order = new Order();
        order.setId(nextId++);
        System.out.println("Create new order with id " + order.getId());
        order.setFood(food);
        food.order();
        System.out.println();
        kitchen.prepare(order);
        return order;
    }
}
