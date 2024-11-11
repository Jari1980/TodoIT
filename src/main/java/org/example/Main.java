package org.example;


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
    }
}