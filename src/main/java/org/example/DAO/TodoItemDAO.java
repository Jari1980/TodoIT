package org.example.DAO;

import org.example.Models.Person;
import org.example.Models.Todo_item;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {
    Todo_item persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator);
    Todo_item findById(int id);
    Collection<Todo_item> findAll();
    Collection<Todo_item> findAllByStatus(boolean done);
    Collection<Todo_item> findByTitleContains(String title);
    Collection<Todo_item> findByPersonId(int personId);
    Collection<Todo_item> findByDeadlineBefore(LocalDate date);
    Collection<Todo_item> findByDeadLineAfter(LocalDate date);
    void remove(int id);
}
