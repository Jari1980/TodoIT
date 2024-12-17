package org.example;

import org.example.Models.Person;
import org.example.Models.Todo_item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemTest {
    Person person = new Person("Jari", "Testar", "test@test");
    //Testing constructor
    @Test
    void todoItemAllGoodTest(){
        Todo_item todoItem = new Todo_item("Todo", "Do this and that", LocalDate.now().plusDays(1), false, person);
        String todoItemSummary = todoItem.toString();
        LocalDate deadline = LocalDate.now().plusDays(1);
        int actualId = todoItem.getId();
        assertEquals(todoItemSummary, "id: " + actualId + "\ntitle: Todo\ndescription: Do this and that\ndeadline: " +
                deadline + "\ndone: false\ncreator: Jari Testar");
    }
    @Test
    void todoItemTitleNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            Todo_item todoItem = new Todo_item(null, "Do this and that", LocalDate.now().plusDays(1), false, person);
        });
    }
    @Test
    void todoItemTitleEmpty(){
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            Todo_item todoItem = new Todo_item("", "Do this and that", LocalDate.now().plusDays(1), false, person);
        });
    }
    @Test
    void todoItemDeadlineNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            Todo_item todoItem = new Todo_item("Todo", "Do this and that", null, false, person);
        });
    }
    //Teting getters and setter
    Todo_item todoItemGetSet = new Todo_item("Todo", "Do this and that", LocalDate.now().minusDays(1), false, person);
    @Test
    void setTitleOk() {
        todoItemGetSet.setTitle("New");
        assertEquals(todoItemGetSet.getTitle(), "New");
    }
    @Test
    void setTitleNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            todoItemGetSet.setTitle(null);
        });
    }
    @Test
    void setTitleEmpty(){
        Assertions.assertThrowsExactly(RuntimeException.class, () -> {
            todoItemGetSet.setTitle("");
        });
    }
    @Test
    void setDeaLineOk(){
        todoItemGetSet.setDeadline(LocalDate.now().plusDays(10));
        assertEquals(todoItemGetSet.getDeadline(), LocalDate.now().plusDays(10));
    }
    @Test
    void setDeadLineNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            todoItemGetSet.setDeadline(null);
        });
    }

    //Testing Overdue
    @Test
    void TodoItemDeadlineOverdue(){
        Todo_item todoItem = new Todo_item("Todo", "Do this and that", LocalDate.now().minusDays(1), false, person);
        assertEquals(todoItem.isOverdue(), true);
    }

}
