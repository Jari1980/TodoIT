package org.example.DAOInterfacesWithGenerics;

import org.example.Models.Person;
import org.example.Models.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAOGen<E> {
    TodoItem persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator);
    TodoItem findById(int id);
    Collection<E> findAll();
    Collection<E> findAllByStatus(boolean done);
    Collection<E> findByTitleContains(String title);
    Collection<E> findByPersonId(int personId);
    Collection<E> findByDeadlineBefore(LocalDate date);
    Collection<E> findByDeadLineAfter(LocalDate date);
    void remove(int id);
}
