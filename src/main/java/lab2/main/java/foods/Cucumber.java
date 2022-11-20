package lab2.main.java.foods;

public class Cucumber extends BurgerDecorator{
    private Burger burger;

    public Cucumber(Burger burger) {
        super(burger);
        this.burger = burger;
    }

    @Override
    public void order() {
        burger.order();
        System.out.print("\n\tcucumber");
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + 3.0;
    }
}
