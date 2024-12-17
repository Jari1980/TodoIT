package org.example.DAOInterfacesWithGenerics;

import org.example.Models.Todo_item;
import org.example.Models.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAOGen<E> {
    TodoItemTask persist(Todo_item todoItem);
    TodoItemTask findById(int id);
    Collection<E> findAll();
    Collection<E> findByAssignedStatus(boolean assigned);
    Collection<E> findByPersonId(int personId);
    void remove(int id);
}
