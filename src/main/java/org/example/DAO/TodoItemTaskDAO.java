package org.example.DAO;

import org.example.Models.TodoItem;
import org.example.Models.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO {
    TodoItemTask persist(TodoItem todoItem);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean assigned);
    Collection<TodoItemTask> findByPersonId(int personId);
    void remove(int id);
}
