package lab1.main.java;

public interface AbstractFactory<T> {
    T create(String name);
}
