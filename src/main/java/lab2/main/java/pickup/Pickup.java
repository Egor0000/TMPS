package lab2.main.java.pickup;

import lab2.main.java.foods.Food;

public abstract class Pickup {
    private final Food food;

    public Pickup(Food food) {
        this.food = food;
    }

    public abstract void deliver();
}
