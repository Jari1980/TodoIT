package org.example.DAOSingleton;

import org.example.DAO.TodoItemTaskDAO;
import org.example.DAO.TodoItemTaskDAOCollection;
import org.example.DAOInterfacesWithGenerics.TodoItemTaskDAOGen;
import org.example.Models.TodoItem;
import org.example.Models.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;

public final class TodoItemTaskDAOCollectionSingleton implements TodoItemTaskDAOGen<TodoItemTask> {
    private static TodoItemTaskDAOCollectionSingleton INSTANCE;
    private ArrayList<TodoItemTask> todoItemTaskList = new ArrayList<>();

    public static TodoItemTaskDAOCollectionSingleton getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new TodoItemTaskDAOCollectionSingleton();
        }
        return INSTANCE;
    }

    @Override
    public TodoItemTask persist(TodoItem todoItem) {
        todoItemTaskList.add(new TodoItemTask(todoItem));
        return todoItemTaskList.getLast();
    }

    @Override
    public TodoItemTask findById(int id) {
        for(TodoItemTask item : todoItemTaskList){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return todoItemTaskList;
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean assigned) {
        ArrayList<TodoItemTask> temp = new ArrayList<>();
        for(TodoItemTask item : todoItemTaskList){
            if(item.isAssigned()){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        ArrayList<TodoItemTask> temp = new ArrayList<>();
        for(TodoItemTask item : todoItemTaskList){
            if(item.getId() == personId){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public void remove(int id) {
        for(TodoItemTask item : todoItemTaskList){
            if(item.getId() == id){
                todoItemTaskList.remove(item);
            }
        }
    }
}
