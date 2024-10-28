package org.example;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        //Testing - Seems to work, cant set fields to null without error and message
        Person test = new Person("Jari", "Testar", "epost");
        /*test.getSummary();
        Person test2 = new Person("Test", "igen då", "mmm");
        test2.setEmail("kk");
        test2.getSummary();*/
        /*
        //Testing if I should use copy of string for getter
        String changingNameTest = test.getFirstName();
        changingNameTest = changingNameTest + "i";
        System.out.println("---------------------");
        System.out.println("testing changes on first name:");
        test.getSummary();
        System.out.println(changingNameTest);
        //Ok using straight copy of string as is

        System.out.println("---------------------");
        TodoItem todoTest = new TodoItem("Todo", "Do this and that", LocalDate.now().plusDays(1), false, test);
        TodoItem todoTest2 = new TodoItem("Todo2", "More stuff to do", LocalDate.now().plusDays(2), false, test);
        todoTest.getSummary();
        System.out.println("Is overtime: " + todoTest.isOverdue());

        System.out.println("--------------------");
        TodoItemTask task1 = new TodoItemTask(todoTest, test);
        TodoItemTask task2 = new TodoItemTask(todoTest2);
        task1.getSummary();
        task2.getSummary(); //assigned false with no assignee
        task2.setAssignee(test);
        task2.getSummary(); //assigned true with assignee
        */
        Person person = new Person("Jari", "Testar", "test@test");
        System.out.println(person.getSummary());
    }
}