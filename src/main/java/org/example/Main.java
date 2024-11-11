package org.example;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AppUserDAOCollection admin = new AppUserDAOCollection();
        admin.persist("JariTestar1", "12345", AppRole.ROLE_APP_ADMIN);
        admin.persist("JariTestar2", "54321", AppRole.ROLE_APP_ADMIN);
        var list = admin.findAll();
        for(AppUser obj : list){
            System.out.println(obj);
        }
    }
}