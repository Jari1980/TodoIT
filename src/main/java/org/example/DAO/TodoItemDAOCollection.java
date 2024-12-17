package org.example.DAO;

import org.example.Models.Person;
import org.example.Models.Todo_item;
import org.example.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemDAOCollection implements TodoItemDAO {
    private ArrayList<Todo_item> todoItemList = new ArrayList<>();


    /*
    @Override
    public Todo_item persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator) {
        int id = TodoItemIdSequencer.nextId();
        todoItemList.add(new Todo_item(title, taskDescription, deadline, done, creator, id));
        return todoItemList.getLast();
    }
     */

    @Override
    public Todo_item findById(int id) {
        for(Todo_item todo : todoItemList){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    @Override
    public Todo_item create(Todo_item todo_item) {
        return null;
    }

    @Override
    public Collection<Todo_item> findAll() {
        return todoItemList;
    }

    @Override
    public Collection<Todo_item> findByDoneStatus(boolean done) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.isDone()){
                temp.add(item);
            }
        }
        return temp;
    }

    /*
    @Override
    public Collection<Todo_item> findByTitleContains(String title) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getTitle().contains(title)){
                temp.add(item);
            }
        }
        return temp;
    }

     */

    @Override
    public Collection<Todo_item> findByAssignee(int personId) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getCreator().getId() == personId){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<Todo_item> findByAssignee(Person person) {
        return List.of();
    }

    @Override
    public Collection<Todo_item> findByUnassignedTodoItems() {
        return List.of();
    }

    @Override
    public Todo_item update(Todo_item todo_item) {
        return null;
    }

    /*
    @Override
    public Collection<Todo_item> findByDeadlineBefore(LocalDate date) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getDeadline().isBefore(date)){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<Todo_item> findByDeadLineAfter(LocalDate date) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getDeadline().isAfter(date)){
                temp.add(item);
            }
        }
        return temp;
    }
     */

    @Override
    public void remove(int id) {
        for(Todo_item item : todoItemList){
            if(item.getId() == id){
                todoItemList.remove(item);
            }
        }
    }
}
