package lab2.main.java.pickup;

import lab2.main.java.foods.Food;

public class Courier extends Pickup {
    private final Food food;
    public Courier(Food food) {
        super(food);
        this.food = food;

    }

    @Override
    public void deliver() {
        System.out.printf("Food %s delivered by courier\n", food.getName());
    }
}
