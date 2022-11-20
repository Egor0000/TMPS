package lab1.main.java.utils;

public class DevUtils {
    private static int id = 0;

    public static int getNextId() {
        return id++;
    }
}
