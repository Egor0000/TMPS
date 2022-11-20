package lab2.main.java.foods;

public abstract class Food {
    private Double price = 0.0;
    private String name;

    public void order() {
        System.out.print("Ordered food ");
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public abstract String getName();
}
