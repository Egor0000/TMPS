package main.java;

public class FrontendDeveloper extends Developer {
    private final TodoList todoList = TodoList.getInstance();
    private int id;

    public FrontendDeveloper(TodoList todoList, int id) {
        super(todoList, id);
        this.id = id;
    }

    @Override
    public String commentItem(int itemId, String comment) throws Exception {
        todoList.addComment(itemId, comment);
        return String.format("WEB Developer %s commented item id = %s. Comment: %s", id, itemId, comment);
    }
}
