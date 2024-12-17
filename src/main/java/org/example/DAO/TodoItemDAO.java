package org.example.DAO;

import org.example.Models.Person;
import org.example.Models.Todo_item;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO {
    //Todo_item persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator);
    Todo_item create(Todo_item todo_item); //refactoring persist -> create and changing argument
    Collection<Todo_item> findAll();
    Todo_item findById(int id);
    Collection<Todo_item> findByDoneStatus(boolean done); //refactored name
    Collection<Todo_item> findByAssignee(int assigneeId); //refactor findByPersonId -> findByAssignee
    Collection<Todo_item> findByAssignee(Person person); //new
    Collection<Todo_item> findByUnassignedTodoItems(); //new
    Todo_item update(Todo_item todo_item); //new
    void remove(int id);
    //Collection<Todo_item> findByTitleContains(String title); //Not used
    //Collection<Todo_item> findByDeadlineBefore(LocalDate date); //Not used
    //Collection<Todo_item> findByDeadLineAfter(LocalDate date); //Not used
}


