package org.example.DAOSingleton;

import org.example.DAOInterfacesWithGenerics.TodoItemDAOGen;
import org.example.Models.Person;
import org.example.Models.Todo_item;
import org.example.sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public final class TodoItemDAOCollectionSingleton implements TodoItemDAOGen<Todo_item> {
    private static TodoItemDAOCollectionSingleton INSTANCE;
    private ArrayList<Todo_item> todoItemList = new ArrayList<>();

    public static TodoItemDAOCollectionSingleton getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new TodoItemDAOCollectionSingleton();
        }
        return INSTANCE;
    }

    @Override
    public Todo_item persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator) {
        int id = TodoItemIdSequencer.nextId();
        todoItemList.add(new Todo_item(title, taskDescription, deadline, done, creator, id));
        return todoItemList.getLast();
    }

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
    public Collection<Todo_item> findAll() {
        return todoItemList;
    }

    @Override
    public Collection<Todo_item> findAllByStatus(boolean done) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.isDone()){
                temp.add(item);
            }
        }
        return temp;
    }

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

    @Override
    public Collection<Todo_item> findByPersonId(int personId) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getId() == personId){
                temp.add(item);
            }
        }
        return temp;
    }

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

    @Override
    public void remove(int id) {
        for(Todo_item item : todoItemList){
            if(item.getId() == id){
                todoItemList.remove(item);
            }
        }
    }
}
