package org.example.DAOSingleton;

import org.example.DAO.AppUserDAO;
import org.example.DAOInterfacesWithGenerics.AppUserDAOGen;
import org.example.Models.AppRole;
import org.example.Models.AppUser;

import java.util.ArrayList;
import java.util.Collection;

public final class AppUserDAOCollectionSingleton implements AppUserDAOGen<AppUser> {
    private static AppUserDAOCollectionSingleton INSTANCE;
    private ArrayList<AppUser> appUserList = new ArrayList<>();

    public static AppUserDAOCollectionSingleton getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new AppUserDAOCollectionSingleton();
        }
        return INSTANCE;
    }

    @Override
    public AppUser persist(String username, String password, AppRole role) {
        appUserList.add(new AppUser(username, password, role));
        return appUserList.getLast();
    }

    @Override
    public AppUser findByUsername(String username) {
        for(AppUser user : appUserList){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    @Override
    public Collection<AppUser> findAll() {
        return appUserList;
    }

    @Override
    public void remove(String username) {
        for(AppUser user : appUserList){
            if(user.getUsername().equals(username)){
                appUserList.remove(user);
            }
        }
    }
}
