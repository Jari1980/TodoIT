package org.example;


import org.example.DAO.*;
import org.example.DAOSingleton.AppUserDAOCollectionSingleton;
import org.example.DAOSingleton.PersonDAOCollectionSingleton;
import org.example.DAOSingleton.TodoItemDAOCollectionSingleton;
import org.example.DAOSingleton.TodoItemTaskDAOCollectionSingleton;
import org.example.Models.AppRole;
import org.example.Models.AppUser;
import org.example.Models.Person;
import org.example.sequencers.PersonIdSequencer;
import org.example.sequencers.TodoItemIdSequencer;
import org.example.sequencers.TodoItemTaskIdSequencer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AppUserDAOCollectionSingleton userAdmin = new AppUserDAOCollectionSingleton();
        userAdmin.persist("JariTestar1", "12345", AppRole.ROLE_APP_ADMIN);
        userAdmin.persist("JariTestar2", "54321", AppRole.ROLE_APP_ADMIN);
        var list = userAdmin.findAll();
        for(AppUser obj : list){
            System.out.println(obj);
        }
        System.out.println("-----------------");

        PersonDAOCollectionSingleton personAdmin = new PersonDAOCollectionSingleton();
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

        TodoItemDAOCollectionSingleton todoAdmin = new TodoItemDAOCollectionSingleton();
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

        TodoItemTaskDAOCollectionSingleton todoItemTaskAdmin = new TodoItemTaskDAOCollectionSingleton();
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

        System.out.println("----------------");
        System.out.println("PersonIdSequencer current id: " + PersonIdSequencer.getCurrentId());
        System.out.println("TodoItemIdSequncer current id: " + TodoItemIdSequencer.getCurrentId());
        System.out.println("TodoItemTaskIdSequncer current id: " + TodoItemTaskIdSequencer.getCurrentId());
    }
}