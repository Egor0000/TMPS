package lab2.main.java.foods;

public class Fish extends BurgerDecorator {
    private Burger burger;

    public Fish(Burger burger) {
        super(burger);
        this.burger = burger;
    }

    @Override
    public void order() {
        burger.order();
        System.out.print("\n\tfish");
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + 4.5;
    }
}
