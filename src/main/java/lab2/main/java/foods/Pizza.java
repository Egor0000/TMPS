package lab2.main.java.foods;

public class Pizza extends Food {
    @Override
    public void order() {
        super.order();
        System.out.print("Pizza: \n");
    }

    @Override
    public String getName() {
        return "Pizza";
    }
}
