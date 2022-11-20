package lab1.main.java;

public interface User {
    String readItem(int itemId) throws Exception;

    String commentItem(int itemId, String comment) throws Exception;

     void addPriority(int itemId, int priority) throws Exception;

     void estimateItem(int itemID, int estimation) throws Exception;
}
