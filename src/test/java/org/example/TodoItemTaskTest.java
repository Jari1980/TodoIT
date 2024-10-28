package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemTaskTest {
    //Constructor, getId, assigned and getsummary
    Person person = new Person("Jari", "Testar", "test@test");
    TodoItem todoItem = new TodoItem("Todo", "Do this and that", LocalDate.now().plusDays(1), false, person);
    @Test
    void todoItemTask2ParamOk(){
        TodoItemTask todoItemTask = new TodoItemTask(todoItem, person);
        int todoItemTaskId = todoItemTask.getId(); //Get Id, assigned and getsummary is tested here aswell
        assertEquals(todoItemTask.getSummary(), "id: " + todoItemTaskId + "\nassigned: true\ntodoItem: Todo\nassignee: Jari Testar");
    }
    @Test
    void todoItemTask2ParamNullTodoItem(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            TodoItemTask todoItemTask = new TodoItemTask(null, person);
        });
    }
    @Test
    void todoItemTask1ParamOk(){
        TodoItemTask todoItemTask = new TodoItemTask(todoItem);
        int todoItemTaskId = todoItemTask.getId(); //Get Id, assigned and getsummary is tested here aswell
        assertEquals(todoItemTask.getSummary(), "id: " + todoItemTaskId + "\nassigned: false\ntodoItem: Todo");
    }
    @Test
    void todoItemTask1ParamNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            TodoItemTask todoItemTask = new TodoItemTask(null);
        });
    }
    //Getters and setter
    TodoItemTask todoItemTaskGetSet = new TodoItemTask(todoItem, person);
    TodoItem todoItemGetSet = new TodoItem("Todo2", "Do this and that2", LocalDate.now().plusDays(1), false, person);
    @Test
    void isAssignedTest(){
        assertEquals(todoItemTaskGetSet.isAssigned(), true);
    }
    @Test
    void setGetTodoItemTest(){
        todoItemTaskGetSet.setTodoItem(todoItemGetSet);
        assertEquals(todoItemTaskGetSet.getSummary(), "id: 1\nassigned: true\ntodoItem: Todo2\nassignee: Jari Testar");
    }
    @Test
    void setTodoItemNullTest(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            todoItemTaskGetSet.setTodoItem(null);
        });
    }
}
