package main.java;

public abstract class Developer implements User {
    private final TodoList todoList;
    private final int id;

    public Developer(TodoList todoList, int id) {
        this.todoList = todoList;
        this.id = id;
    }

    @Override
    public String readItem(int itemId) throws Exception {
        String content = todoList.readItem(itemId);
        return String.format("Developer %s read item id = %s. Content: %s", id, itemId, content);
    }

    @Override
    public String commentItem(int itemId, String comment) throws Exception {
        todoList.addComment(itemId, comment);
        return String.format("Developer %s commented item id = %s. Comment: %s", id, itemId, comment);
    }

    @Override
    public void addPriority(int itemId, int priority) throws Exception {
        if (priority < 2) {
            throw new RuntimeException("Developer cannot set priority less then 2");
        }

        Item item = todoList.getById(itemId);

        item.setPriority(priority);
    }

    @Override
    public void estimateItem(int itemID, int estimation) throws Exception {
        Item item = todoList.getById(itemID);

        item.setDeveloperEstimation(estimation);
    }


}
