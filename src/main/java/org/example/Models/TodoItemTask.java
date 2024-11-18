package org.example.Models;

import org.example.sequencers.TodoItemIdSequencer;
import org.example.sequencers.TodoItemTaskIdSequencer;

import java.util.Objects;

public class TodoItemTask {
    //private static int counter = 1;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee, int id) {
        if (assignee != null){
            this.assigned = true;
        }
        this.todoItem = Objects.requireNonNull(todoItem, "TodoItem cant be null.");
        this.assignee = assignee;
        this.id = id;
        //this.id = TodoItemIdSequencer.nextId();
    }

    public TodoItemTask(TodoItem todoItem, int id) {
        this.todoItem = Objects.requireNonNull(todoItem, "TodoItem cant be null.");
        this.id = id;
        //TodoItemTaskIdSequencer.nextId();
        //this.id = TodoItemTaskIdSequencer.getCurrentId();
    }

    @Override
    public String toString(){
        //System.out.println("id: " + id + "\nassigned: " + assigned + "\ntodoItem: " + todoItem.getTitle());
        //if (assignee != null){
        //   System.out.println("assignee: " + assignee.getFirstName() + " " + assignee.getLastName());
        //}
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("\nassigned: ");
        sb.append(assigned);
        sb.append("\ntodoItem: ");
        sb.append(todoItem.getTitle());
        /*if(assignee != null){
            sb.append("\nassignee: ");
            sb.append(assignee.getFirstName());
            sb.append(" ");
            sb.append(assignee.getLastName());
        }*/
        return sb.toString();
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
        this.todoItem = Objects.requireNonNull(todoItem, "TodoItem cant be null.");
    }

    public void setAssignee(Person assignee) {
        if(assignee == null){
            this.assigned = false;
        }
        this.assignee = assignee;
        this.assigned = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id && assigned == that.assigned && Objects.equals(todoItem, that.todoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }
}
