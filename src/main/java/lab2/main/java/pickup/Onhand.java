package lab2.main.java.pickup;

import lab2.main.java.foods.Food;

public class Onhand extends Pickup {
    private final Food food;
    public Onhand(Food food) {
        super(food);
        this.food = food;
    }
    @Override
    public void deliver() {
        System.out.printf("Order with food %s picked up by client\n", food.getName());
    }
}
