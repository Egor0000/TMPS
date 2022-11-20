package lab1.main.java.impl;

import lab1.main.java.Developer;

public class BackendDeveloper extends Developer {
    private final TodoList todoList = TodoList.getInstance();
    private int id;

    public BackendDeveloper(TodoList todoList, int id) {
        super(todoList, id);
        this.id = id;
    }

    @Override
    public String commentItem(int itemId, String comment) throws Exception {
        todoList.addComment(itemId, comment);
        return String.format("Backend Developer %s commented item id = %s. Comment: %s", id, itemId, comment);
    }

    @Override
    public Developer clone() {
        BackendDeveloper developer = new BackendDeveloper(todoList, this.id);
        return developer;
    }
}
