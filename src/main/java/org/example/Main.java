package org.example;


import org.example.DAO.AppUserDAOCollection;
import org.example.DAO.PersonDAOCollection;
import org.example.DAO.TodoItemTaskDAO;
import org.example.DAO.TodoItemTaskDAOCollection;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AppUserDAOCollection userAdmin = new AppUserDAOCollection();
        userAdmin.persist("JariTestar1", "12345", AppRole.ROLE_APP_ADMIN);
        userAdmin.persist("JariTestar2", "54321", AppRole.ROLE_APP_ADMIN);
        var list = userAdmin.findAll();
        for(AppUser obj : list){
            System.out.println(obj);
        }
        System.out.println("-----------------");

        PersonDAOCollection personAdmin = new PersonDAOCollection();
        personAdmin.persist("Jari", "Test1", "epost");
        personAdmin.persist("Jari", "Test2", "epost");
        personAdmin.persist("Jari", "Test3", "epost");
        personAdmin.persist("Jari", "Test4", "epost");
        personAdmin.persist("Jari", "Test5", "epost");
        for(Person obj : personAdmin.findAll()){
            System.out.println(obj);
        }
        personAdmin.remove(4);
        for(Person obj : personAdmin.findAll()){
            System.out.println(obj);
        }
        System.out.println("--------------------------");

        TodoItemDAOCollection todoAdmin = new TodoItemDAOCollection();
        todoAdmin.persist("Test1", "Description1", LocalDate.of(2024, 11, 20), true, personAdmin.findById(1));
        todoAdmin.persist("Test2", "Description2", LocalDate.of(2024, 11, 1), true, personAdmin.findById(1));
        todoAdmin.persist("Test3", "Description3", LocalDate.of(2024, 11, 25), false, personAdmin.findById(2));
        todoAdmin.persist("Test4", "Description4", LocalDate.of(2024, 11, 17), false, personAdmin.findById(2));
        todoAdmin.persist("Test5", "Description5", LocalDate.of(2024, 11, 29), false, personAdmin.findById(2));
        System.out.println(todoAdmin.findAll());
        System.out.println("---------------------------");
        System.out.println(todoAdmin.findAllByStatus(true));
        System.out.println("------------------------------");
        System.out.println(todoAdmin.findByTitleContains("Tes"));
        System.out.println("------------------");
        System.out.println(todoAdmin.findByDeadlineBefore(LocalDate.of(2024, 11, 25)));
        System.out.println("---------------------------------------");

        TodoItemTaskDAOCollection todoItemTaskAdmin = new TodoItemTaskDAOCollection();
        todoItemTaskAdmin.persist(todoAdmin.findById(1));
        todoItemTaskAdmin.persist(todoAdmin.findById(2));
        todoItemTaskAdmin.persist(todoAdmin.findById(3));
        todoItemTaskAdmin.persist(todoAdmin.findById(4));
        System.out.println(todoItemTaskAdmin.findAll());
        todoItemTaskAdmin.findById(1).setAssignee(personAdmin.findById(1));
        System.out.println("----------------");
        System.out.println(todoItemTaskAdmin.findAll());
        System.out.println("----------------");
        System.out.println(todoItemTaskAdmin.findByAssignedStatus(true));
    }
}