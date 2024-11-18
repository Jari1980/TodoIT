package org.example.DAO;

import org.example.Models.TodoItem;
import org.example.Models.TodoItemTask;
import org.example.sequencers.TodoItemIdSequencer;

import java.util.ArrayList;
import java.util.Collection;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {
    private ArrayList<TodoItemTask> todoItemTaskList = new ArrayList<>();


    @Override
    public TodoItemTask persist(TodoItem todoItem) {
        int id = TodoItemIdSequencer.nextId();
        todoItemTaskList.add(new TodoItemTask(todoItem, id));
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
            if(item.getAssignee().getId() == personId){
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
