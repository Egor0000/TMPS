package lab2.main.java.pickup;

import lab2.main.java.foods.Food;

public class Rideshare extends Pickup {
    private final Food food;
    public Rideshare(Food food) {
        super(food);
        this.food = food;
    }
    @Override
    public void deliver() {
        System.out.printf("Food %s delivered by rideshare\n", food.getName());
    }
}
