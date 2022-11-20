package lab2.main.java.foods;

public class Cheese extends BurgerDecorator {
    private Burger burger;

    public Cheese(Burger burger) {
        super(burger);
        this.burger = burger;
    }

    @Override
    public void order() {
        burger.order();
        System.out.print("\n\tcheese");
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 4.0;
    }
}
