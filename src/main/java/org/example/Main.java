package org.example;


import org.example.DAO.*;
import org.example.DAOSingleton.AppUserDAOCollectionSingleton;
import org.example.DAOSingleton.PersonDAOCollectionSingleton;
import org.example.DAOSingleton.TodoItemDAOCollectionSingleton;
import org.example.DAOSingleton.TodoItemTaskDAOCollectionSingleton;
import org.example.DAOStream.AppUserDAOCollectionStream;
import org.example.Models.AppRole;
import org.example.Models.AppUser;
import org.example.Models.Person;
import org.example.Models.Todo_item;
import org.example.sequencers.PersonIdSequencer;
import org.example.sequencers.TodoItemIdSequencer;
import org.example.sequencers.TodoItemTaskIdSequencer;

import java.sql.*;
import java.time.LocalDate;

import static org.example.db.MySQLConnection.getConnection;

public class Main {
    public static void main(String[] args) {

        //----------------Testing implementation of TodoItemDAOCollection---------------------------------
        TodoItemDAOCollection testProg2 = new TodoItemDAOCollection();
        Person inDb = new Person(5, "Jari", "TestarMer"); //Using existing persons in db as assignees
        Person inDb2 = new Person(4, "Jari", "Testar");

        //Testing add todo_item //Working

        //System.out.println(testProg2.create(new Todo_item("Eat Broccoli", "Eat Good", LocalDate.of(2024,12,12), false, inDb)));
        //System.out.println(testProg2.create(new Todo_item("Eat Broccoli", "Eat A Lot", LocalDate.of(2024,12,31), false, inDb)));
        //System.out.println(testProg2.create(new Todo_item("Drink Beer", "Enjoy", LocalDate.of(2024,12,12), false, inDb2)));
        //System.out.println(testProg2.create(new Todo_item("Have Snus", "mm", LocalDate.of(2024,12,12), true, inDb)));
        //System.out.println(testProg2.create(new Todo_item("Have Snus", "mm", LocalDate.of(2024,12,31), true, null)));


        //Testing findby todo_id //Working

        //System.out.println(testProg2.findById(1));


        //Testing find all todo_item //Working

        //System.out.println(testProg2.findAll());


        //Testing find by done //Working

        //System.out.println(testProg2.findByDoneStatus(false));


        //Testing find by assignee //Working

        //System.out.println(testProg2.findByAssignee(5));


        //Testing find by assignee (v2) //Working

        //PersonDAOCollection testProg22 = new PersonDAOCollection();
        //System.out.println(testProg2.findByAssignee(testProg22.findById(4)));


        //Testing by unassigned todos //Working

        //System.out.println(testProg2.findByUnassignedTodoItems());


        //Testing uppdate todo_item //Working

        //Todo_item existing = new Todo_item("Eat Broccoli", "Eat Like Never Before", LocalDate.of(2024,12,12), false, inDb, 1);
        //System.out.println(testProg2.update(existing));


        //Testing remove  //Working

        //testProg2.remove(4);


        //----------------Testing implementation of PersonDAOCollection-------------------------------
        PersonDAOCollection testProg = new PersonDAOCollection();


        //Testing add person //Works fine

        //System.out.println(testProg.create("Broccoli", "Broccolison"));
        //System.out.println(testProg.create("Broccoli", "Snusson"));
        //System.out.println(testProg.create("Broccoli", "Tomte"));
        //System.out.println(testProg.create("Jari", "Testar"));
        //System.out.println(testProg.create("Jari", "TestarMer"));


        //Testing findBy id //Works fine

        //System.out.println(testProg.findById(4));


        //Testing find by name //Works fine

        //System.out.println(testProg.findByName("roc"));


        //Testing find all //Works fine

        //System.out.println(testProg.findAll());


        //Testing update person //Works

        //System.out.println(testProg.update(new Person(1, "Updated Broccoli", "Broccolison")));


        //Testing remove person //Works fine

        //testProg.remove(3);

        //----------------------------------------------------------------------------------




        // Below is tests for older part 1-3 assignments

        /*
        AppUserDAOCollectionStream userAdmin = new AppUserDAOCollectionStream();
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


        System.out.println("----------------");
        System.out.println("PersonIdSequencer current id: " + PersonIdSequencer.getCurrentId());
        System.out.println("TodoItemIdSequencer current id: " + TodoItemIdSequencer.getCurrentId());
        System.out.println("TodoItemTaskIdSequencer current id: " + TodoItemTaskIdSequencer.getCurrentId());
        System.out.println("-----------------");

        System.out.println(userAdmin.findAll());
        System.out.println("------------");
        System.out.println(userAdmin.findByUsername("JariTestar2"));
        userAdmin.remove("JariTestar2");
        System.out.println(userAdmin.findAll());
        */
    }
}