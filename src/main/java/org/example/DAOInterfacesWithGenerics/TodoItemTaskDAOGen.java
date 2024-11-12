package org.example.DAOInterfacesWithGenerics;

import org.example.Models.TodoItem;
import org.example.Models.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAOGen<E> {
    TodoItemTask persist(TodoItem todoItem);
    TodoItemTask findById(int id);
    Collection<E> findAll();
    Collection<E> findByAssignedStatus(boolean assigned);
    Collection<E> findByPersonId(int personId);
    void remove(int id);
}
