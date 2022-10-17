package main.java.impl;

import main.java.User;

public class TeamLeader implements User {
    private final TodoList todoList;
    private final int id;

    public TeamLeader(TodoList todoList, int id) {
        this.todoList = todoList;
        this.id = id;
    }

    @Override
    public String readItem(int itemID) throws Exception {
        String content = todoList.readItem(itemID);
        return String.format("Team leader id=%s read item (id =%s). Content = %s", id, itemID, content);
    }

    @Override
    public String commentItem(int itemId, String comment) throws Exception {
        todoList.addComment(itemId, comment);
        return String.format("TeamLeader %s commented item id = %s. Comment: %s", id, itemId, comment);
    }

    @Override
    public void addPriority(int itemId, int priority) throws Exception {
        Item item = todoList.getById(itemId);

        item.setPriority(priority);
    }

    @Override
    public void estimateItem(int itemID, int estimation) throws Exception {
        Item item = todoList.getById(itemID);

        item.setTeamLeadEstimation(estimation);
    }

    public boolean createItem(Item item) {
        return todoList.addToList(item);
    }

    public boolean deleteItem(int itemId) throws Exception {
        return todoList.deleteFromList(itemId);
    }

    public void updateItem(Item newItem) throws Exception {
        todoList.updateItem(newItem);
    }
}
