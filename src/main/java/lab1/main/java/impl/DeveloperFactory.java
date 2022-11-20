package lab1.main.java.impl;

import lab1.main.java.*;
import lab1.main.java.enums.Department;
import lab1.main.java.utils.DevUtils;

public class DeveloperFactory implements AbstractFactory<Developer> {
    private final TodoList todoList = TodoList.getInstance();

    @Override
    public Developer create(String name) {
        Department department = Department.valueOf(name);
        int id = DevUtils.getNextId();
        if (department.equals(Department.BACK)) {
            return new BackendDeveloper(todoList, id);
        } else if (department.equals(Department.WEB)) {
            return new FrontendDeveloper(todoList, id);
        } else if (department.equals(Department.MOBILE)) {
            return new MobileDeveloper(todoList, id);
        }
        return null;
    }
}
