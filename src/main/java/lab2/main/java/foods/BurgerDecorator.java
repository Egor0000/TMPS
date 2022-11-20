package lab2.main.java.foods;

public class BurgerDecorator extends Burger {
    private final Burger burger;

    public BurgerDecorator(Burger burger) {
        this.burger = burger;
    }

    @Override
    public void order() {
        burger.order();
    }

    @Override
    public Double getPrice() {
        return super.getPrice();
    }
}
