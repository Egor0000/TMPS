package lab2.main.java.foods;

public class Burger extends Food {
    @Override
    public void order() {
        super.order();
        System.out.print("Burger:");
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 10.0;
    }

    @Override
    public String getName() {
        return "Burger";
    }
}
