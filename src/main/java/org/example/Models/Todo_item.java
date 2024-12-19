package org.example.Models;

import java.time.LocalDate;
import java.util.Objects;

public class Todo_item {
    //private static int counter = 1;
    private int todo_id; //Refactored id -> todo_id
    private String title;
    private String description; //Refactored taskDescription -> description
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    public Todo_item(String title, String taskDescription, LocalDate deadline, boolean done, Person creator, int id) {
        if (title.isEmpty()) {
            throw new RuntimeException("Title cant be empty.");
        }
        this.title = Objects.requireNonNull(title, "Title cant be null.");
        this.description = taskDescription;
        this.deadline = Objects.requireNonNull(deadline, "Deadline cant be null.");
        this.done = done;
        this.creator = creator;
        //this.id = id;
        this.todo_id = id;
    }

    //Adding default constructor and constructor w/o todo_id used in db implementation and w/o assignee


    public Todo_item(int todo_id, String title, String description, LocalDate deadline, boolean done) {
        this.todo_id = todo_id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
    }

    public Todo_item(String title, String description, LocalDate deadline, boolean done, Person creator) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.creator = creator;
    }
    public Todo_item() {
    }

    @Override
    public String toString(){
        //System.out.println("id: " + id + "\ntitle: " + title + "\ndecription: " + taskDescription + "\ndeadline: " + deadline +
         //       "\ndone: " + done + "\ncreator: " + creator.getFirstName() + " " + creator.getLastName());
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(todo_id);
        sb.append("\ntitle: ");
        sb.append(title);
        sb.append("\ndescription: ");
        sb.append(description);
        sb.append("\ndeadline: ");
        sb.append(deadline);
        sb.append("\ndone: ");
        sb.append(done);
        /*sb.append("\ncreator: ");
        sb.append(creator.getFirstName());
        sb.append(" ");
        sb.append(creator.getLastName());*/
        return sb.toString();
    }

    public boolean isOverdue(){
        if (LocalDate.now().isAfter(deadline)){
            return true;
        }
        else{
            return false;
        }
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            throw new RuntimeException("Title cant be empty.");
        }
        this.title = Objects.requireNonNull(title, "Title cant be null.");
    }

    public void setTaskDescription(String taskDescription) {
        this.description = taskDescription;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = Objects.requireNonNull(deadline, "Deadline cant be null.");
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public int getId() {
        return todo_id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return done;
    }

    public Person getCreator() {
        return creator;
    }


    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo_item todoItem = (Todo_item) o;
        return todo_id == todoItem.todo_id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo_id, title, description, deadline, done);
    }
}
