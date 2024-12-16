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
import org.example.sequencers.PersonIdSequencer;
import org.example.sequencers.TodoItemIdSequencer;
import org.example.sequencers.TodoItemTaskIdSequencer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercises", "root", "****");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER");

            while(rs.next()){
                System.out.println("Id: " + rs.getString("customer_id"));
                System.out.println("Name: " + rs.getString("cust_name"));
                System.out.println("City: " + rs.getString("city"));
            }
        }


        catch (Exception e){
            System.out.println("Something wrong");
        }



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