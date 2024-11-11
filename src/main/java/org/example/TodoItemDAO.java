package org.example;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {
    TodoItem persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator);
    TodoItem findById(int id);
    Collection<TodoItem> findAll();
    Collection<TodoItem> findAllByStatus(boolean done);
    Collection<TodoItem> findByTitleContains(String title);
    Collection<TodoItem> findByPersonId(int personId);
    Collection<TodoItem> findByDeadlineBefore(LocalDate date);
    Collection<TodoItem> findByDeadLineAfter(LocalDate date);
    void remove(int id);
}
