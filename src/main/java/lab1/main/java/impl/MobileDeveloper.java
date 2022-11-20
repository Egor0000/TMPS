package lab1.main.java.impl;

import lab1.main.java.Developer;

public class MobileDeveloper extends Developer {
    private final TodoList todoList = TodoList.getInstance();
    private int id;

    public MobileDeveloper(TodoList todoList, int id) {
        super(todoList, id);
        this.id = id;
    }

    public MobileDeveloper(TodoList todoList, int id, int id1) {
        super(todoList, id);
        this.id = id1;
    }

    @Override
    public String commentItem(int itemId, String comment) throws Exception {
        todoList.addComment(itemId, comment);
        return String.format("Mobile Developer %s commented item id = %s. Comment: %s", id, itemId, comment);
    }

    @Override
    public Developer clone() {
        MobileDeveloper developer = new MobileDeveloper(todoList, this.id);
        return developer;
    }
}
