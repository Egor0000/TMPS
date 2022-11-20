package lab1.main.java.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private List<Item> items = new ArrayList<>();
    private static TodoList instance = new TodoList();

    private TodoList() {
    }

    public static TodoList getInstance() {
        return instance;
    }

    public boolean addToList(Item item) {
        return items.add(item);
    }

    public void addToAll(List<Item> items) {
        this.items.addAll(items);
    }

    public boolean deleteFromList(int itemId) throws Exception {
        Item item = getById(itemId);
        return items.remove(item);
    }

    public void deleteFromListByName(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    public List<Item> getAll() {
        return items;
    }

    public List<Item> getAllByPriority(int priority) {
        return items.stream().filter(item -> item.getPriority() == priority).collect(Collectors.toList());
    }

    public List<Item> getNextItemsToBeDone() {
        return getAllByPriority(getMaxPriority());
    }

    public Item getById(int id) throws Exception {
        return items.stream()
                .filter(item -> item.getId()==id)
                .findFirst()
                .orElseThrow(()->new Exception(String.format("No element with id = %s found", id)));
    }

    public void updateItem(Item item) throws Exception {
        if (item.getId() == null) {
            throw new Exception("Null id for input item");
        }
        Item oldItem = getById(item.getId());

        oldItem.setDeveloperEstimation(item.getId());
        oldItem.setPriority(item.getPriority());
        oldItem.setContent(item.getContent());
        oldItem.setName(item.getName());
        oldItem.setDeveloperEstimation(item.getDeveloperEstimation());
        oldItem.setTeamLeadEstimation(item.getTeamLeadEstimation());
        oldItem.setComments(item.getComments()!=null?item.getComments():new ArrayList<>());
    }

    public void addComment(int itemId, String comment) throws Exception {
        Item item = getById(itemId);
        item.getComments().add(comment);
    }

    public String readItem(int itemId) throws Exception {
        Item item = getById(itemId);
        return item.getContent();
    }

    private int getMaxPriority() {
        return items.stream().map(Item::getPriority).mapToInt(v -> v).min().orElse(0);
    }

}
