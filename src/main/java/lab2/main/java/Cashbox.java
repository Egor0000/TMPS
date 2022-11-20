package lab2.main.java;

import lab2.main.java.user.User;
import lab2.main.java.user.UserService;
import lab2.main.java.user.UserServiceProxy;

public class Cashbox {
    private boolean opened;
    private final UserService userService = UserServiceProxy.getInstance();
    public void open() {
        this.opened = true;
        System.out.println("Opened cashbox");
    }

    public void close() {
        this.opened = false;
        System.out.println("Closed cashbox");
    }

    public void payOrder(Order order, User user) {
        User registeredUser = null;
        boolean registered = false;
        try {
            System.out.println("Searching for registered users ... ");
            registeredUser = userService.getUserById(user.getId());
            if (registeredUser != null) {
                System.out.println("Found registered user");
                registered = true;
            } else {
                System.out.println("No registered user found");
                userService.addNewUser(user);
            }
        } catch (Exception ignore) {

        }

        System.out.println("Paying the order ... ");
        order.setPrice(order.getFood().getPrice());
        if (registered) {
            System.out.println("Making a discount 10% for registered user");
            order.setPrice(order.getPrice()*9/10);
        }

        System.out.println("Total for paying: " + order.getPrice());
    }
}
