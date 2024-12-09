package org.example.Models;

import org.example.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    //private static int counter = 1;
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadline;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String taskDescription, LocalDate deadline, boolean done, Person creator, int id) {
        if (title.isEmpty()) {
            throw new RuntimeException("Title cant be empty.");
        }
        this.title = Objects.requireNonNull(title, "Title cant be null.");
        this.taskDescription = taskDescription;
        this.deadline = Objects.requireNonNull(deadline, "Deadline cant be null.");
        this.done = done;
        this.creator = creator;
        //this.id = id;
        this.id = id;
    }

    @Override
    public String toString(){
        //System.out.println("id: " + id + "\ntitle: " + title + "\ndecription: " + taskDescription + "\ndeadline: " + deadline +
         //       "\ndone: " + done + "\ncreator: " + creator.getFirstName() + " " + creator.getLastName());
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("\ntitle: ");
        sb.append(title);
        sb.append("\ndescription: ");
        sb.append(taskDescription);
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
        this.taskDescription = taskDescription;
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
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && done == todoItem.done && Objects.equals(title, todoItem.title) && Objects.equals(taskDescription, todoItem.taskDescription) && Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadline, done);
    }
}
