package lab2.main.java;

import lab2.main.java.foods.*;
import lab2.main.java.pickup.Courier;
import lab2.main.java.pickup.Onhand;
import lab2.main.java.pickup.Pickup;
import lab2.main.java.serializer.XmlAdapter;
import lab2.main.java.serializer.XmlSerializer;
import lab2.main.java.user.User;

public class Main {
    public static void main(String[] args) throws Exception {
        RestaurantFacade restaurantFacade = new RestaurantFacade();
        restaurantFacade.open();

        User user = new User();
        user.setUid("hd923b01");
        user.setName("John");
        user.setSurname("Doe");

        Burger burger = new Onion(new Fish(new Burger()));

        Order order = restaurantFacade.order(burger);
        restaurantFacade.pay(order, user);

        new Onhand(order.getFood()).deliver();

        Burger nextBurger = new Cucumber(burger);

        Order order2 = restaurantFacade.order(nextBurger);
        restaurantFacade.pay(order2, user);

        new Courier(order.getFood()).deliver();

        System.out.println(new XmlAdapter(new XmlSerializer()).userToXml(user));

        System.out.print("Restaurant is working |#    |\r");
        Thread.sleep(1000);
        System.out.print("Restaurant is working |###  |\r");
        Thread.sleep(1000);
        System.out.print("Restaurant is working |#####|\n");
        Thread.sleep(1000);

        restaurantFacade.close();
    }
}
