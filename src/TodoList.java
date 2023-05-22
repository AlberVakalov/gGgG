package src;

import java.util.ArrayList;


public class TodoList {

    static ArrayList<String> toDoList = new ArrayList<>();


    public void add(String todo) {
        toDoList.add(todo);
        System.out.println("Дело " + todo + " добавлено в конец списка");
    }

    public void add(int index, String todo) {
        if (index >= 0 && index <= toDoList.size()) {
            toDoList.add(index, todo);
            System.out.println("Дело " + todo + " добавлено на позицию " + index);
        } else if (index >= toDoList.size()) {
            toDoList.add(todo);
            System.out.println("Дело " + todo + " добавлено на позицию " + index);
        } else {
            System.out.println("Невозможно добавить дело " + todo);
        }
    }

    public void edit(int index, String todo) {
        if (index >= 0 && index < toDoList.size()) {
            toDoList.set(index, todo);
            System.out.println("Дело " + todo + " изменено");
        } else {
            System.out.println("Невозможно изменить дело");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < toDoList.size()) {
            toDoList.remove(index);
            System.out.println("Дело удалено");
        } else {
            System.out.println("Дела с номером " + index + " не существует");
        }
    }

    public ArrayList<String> getTodos() {
        return toDoList;
    }


    public void listMatcher() {
        System.out.println("Полный список дел: ");
        ArrayList<String> todos = getTodos();
        for (int i = 0; i < todos.size(); i++)
            System.out.println((i + 1) + ". " + todos.get(i));
    }

    public void addMatcher(String task) {
        System.out.println("Дело " + task + " добавлено");
        add(task);
    }
    public void addMatcherIndex(String task, int index) {
        System.out.println("Дело " + task + " добавлено");
        add(index, task);
    }

    public void editMatcher(int index, String toDo) {
        System.out.println("Дело под номером: " + index + " изменено, на " + toDo);
        edit(index, toDo);
    }

    public void deleteMatcher(int delIndex) {
        System.out.println("Введите номер дела, который вы хотите удалить: ");
        delete(delIndex);
    }

    public void showError() {
        System.out.println("Некорректная команда. Попробуйте еще раз.");
    }

    public String[] parseInput(String all) {
        return all.split(" ", 3);
    }
}