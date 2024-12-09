package org.example.DAOSingleton;

import org.example.DAO.TodoItemDAO;
import org.example.DAOInterfacesWithGenerics.TodoItemDAOGen;
import org.example.Models.Person;
import org.example.Models.TodoItem;
import org.example.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public final class TodoItemDAOCollectionSingleton implements TodoItemDAOGen<TodoItem> {
    private static TodoItemDAOCollectionSingleton INSTANCE;
    private ArrayList<TodoItem> todoItemList = new ArrayList<>();

    public static TodoItemDAOCollectionSingleton getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new TodoItemDAOCollectionSingleton();
        }
        return INSTANCE;
    }

    @Override
    public TodoItem persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator) {
        int id = TodoItemIdSequencer.nextId();
        todoItemList.add(new TodoItem(title, taskDescription, deadline, done, creator, id));
        return todoItemList.getLast();
    }

    @Override
    public TodoItem findById(int id) {
        for(TodoItem todo : todoItemList){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return todoItemList;
    }

    @Override
    public Collection<TodoItem> findAllByStatus(boolean done) {
        ArrayList<TodoItem> temp = new ArrayList<>();
        for(TodoItem item : todoItemList){
            if(item.isDone()){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        ArrayList<TodoItem> temp = new ArrayList<>();
        for(TodoItem item : todoItemList){
            if(item.getTitle().contains(title)){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        ArrayList<TodoItem> temp = new ArrayList<>();
        for(TodoItem item : todoItemList){
            if(item.getId() == personId){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        ArrayList<TodoItem> temp = new ArrayList<>();
        for(TodoItem item : todoItemList){
            if(item.getDeadline().isBefore(date)){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<TodoItem> findByDeadLineAfter(LocalDate date) {
        ArrayList<TodoItem> temp = new ArrayList<>();
        for(TodoItem item : todoItemList){
            if(item.getDeadline().isAfter(date)){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public void remove(int id) {
        for(TodoItem item : todoItemList){
            if(item.getId() == id){
                todoItemList.remove(item);
            }
        }
    }
}
