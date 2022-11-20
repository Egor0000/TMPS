package lab2.main.java.foods;

public class Onion extends BurgerDecorator{
    private  Burger burger;

    public Onion(Burger burger) {
        super(burger);
        this.burger = burger;
    }

    @Override
    public void order() {
        burger.order();
        System.out.print("\n\tonion");
    }

    @Override
    public Double getPrice() {
        return burger.getPrice() + 2.0;
    }
}
