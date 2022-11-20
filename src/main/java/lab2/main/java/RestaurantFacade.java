package lab2.main.java;

import lab2.main.java.foods.Food;
import lab2.main.java.user.User;

public class RestaurantFacade {
    private final RestaurantHall restaurantHall;
    private final Kitchen kitchen;
    private final Cashbox cashbox;

    public RestaurantFacade() {
        restaurantHall = new RestaurantHall();
        kitchen = Kitchen.getInstance();
        cashbox = new Cashbox();
    }

    public void open() {
        this.cashbox.open();
        this.kitchen.open();
        this.restaurantHall.open();
    }

    public void close() {
        this.cashbox.close();
        this.kitchen.close();
        this.restaurantHall.close();
    }

    public Order order(Food food) {
        return restaurantHall.order(food);
    }

    public void pay(Order order, User user) {
        cashbox.payOrder(order, user);
    }

}
