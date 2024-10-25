package org.example;

import java.util.Objects;

public class TodoItemTask {
    private static int counter = 1;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        if (assignee != null){
            this.assigned = true;
        }
        this.todoItem = Objects.requireNonNull(todoItem, "TodoItem cant be null.");
        this.assignee = assignee;
        this.id = counter++;
    }

    public TodoItemTask(TodoItem todoItem) {
        this.todoItem = Objects.requireNonNull(todoItem, "TodoItem cant be null.");
        this.id = counter++;
    }

    public void getSummary(){
        System.out.println("id: " + id + "\nassigned: " + assigned + "\ntodoItem: " + todoItem.getTitle());
        if (assignee != null){
            System.out.println("assignee: " + assignee.getFirstName() + " " + assignee.getLastName());
        }
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public void setAssignee(Person assignee) {
        if(assignee == null){
            this.assigned = false;
        }
        this.assignee = assignee;
        this.assigned = true;
    }
}
