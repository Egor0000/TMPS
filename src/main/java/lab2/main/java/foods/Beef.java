package lab2.main.java.foods;

public class Beef extends BurgerDecorator{
    private Burger burger;

    public Beef(Burger burger) {
        super(burger);
        this.burger = burger;
    }

    @Override
    public void order() {
        burger.order();
        System.out.print("\n\tbeef");
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 5.0;
    }
}
