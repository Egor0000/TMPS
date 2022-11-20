package lab1.main.java.impl;

import lab1.main.java.*;
import lab1.main.java.enums.Department;

import java.util.ArrayList;
import java.util.List;

public class Board implements Simulation {

    public void startSimulation() throws Exception {
        System.out.println("STARTING DEV BOARD SIMULATION");

        TodoList todoList = TodoList.getInstance();

        List<Developer> devs = new ArrayList<>();
        getNextDev( devs, Department.BACK,3);
        getNextDev( devs, Department.WEB,2);

        TeamLeader teamLeader = new TeamLeader(todoList, 0);
        Item item = new Item.ItemBuilder(0)
                .name("task1")
                .content("todo1")
                .build();

        Item item2 = item.clone();
        item2.setName("task2");
        item2.setContent("todo2");
        item2.setId(1);

        Item item3 = item.clone();
        item3.setName("task3");
        item3.setContent("todo3");
        item3.setId(2);

        teamLeader.createItem(item);
        teamLeader.createItem(item2);
        teamLeader.createItem(item3);

        teamLeader.addPriority(0, 1);
        teamLeader.addPriority(1, 2);
        teamLeader.addPriority(2, 4);

        teamLeader.estimateItem(0, 5);
        teamLeader.estimateItem(1, 8);
        teamLeader.estimateItem(2, 12);

        System.out.println(comment(devs.get(0), 0, "This estimation is incorrect"));

        devs.get(0).estimateItem(0, 10);

        System.out.println(comment(devs.get(1),1, "This task is deprecated"));

        teamLeader.deleteItem(1);

        System.out.println(comment(teamLeader, 2, "This item should have other text"));

        teamLeader.updateItem(new Item.ItemBuilder(2).content("ModifiedText").build());
    }

    private void getNextDev(List<Developer> developers, Department department, int maxIdx) {
        while (maxIdx >0) {
            developers.add(new DeveloperFactory().create(department.toString()));
            maxIdx--;
        }
    }

    private String comment(User user, int itemId, String comment) throws Exception {
        return user.commentItem(itemId, comment);
    }
}
