package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDAOCollection implements  AppUserDAO{
    private ArrayList<AppUser> appUserList = new ArrayList<>();

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
