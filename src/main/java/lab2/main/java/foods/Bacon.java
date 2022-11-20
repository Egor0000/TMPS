package lab2.main.java.foods;

public class Bacon extends BurgerDecorator {
    private Burger burger;

    public Bacon(Burger burger) {
        super(burger);
        this.burger = burger;
    }

    @Override
    public void order() {
        burger.order();
        System.out.print("\n\tbacon");
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 7.0;
    }
}
