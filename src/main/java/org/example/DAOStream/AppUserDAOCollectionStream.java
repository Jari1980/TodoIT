package org.example.DAOStream;

import org.example.DAOInterfacesWithGenerics.AppUserDAOGen;
import org.example.Models.AppRole;
import org.example.Models.AppUser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class AppUserDAOCollectionStream implements AppUserDAOGen<AppUser> {
    private static AppUserDAOCollectionStream INSTANCE;
    //private Stream<AppUser> appUserList = Stream.empty();
    private ArrayList<AppUser> appUserList = new ArrayList<>();

    public static AppUserDAOCollectionStream getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new AppUserDAOCollectionStream();
        }
        return INSTANCE;
    }

    @Override
    public AppUser persist(String username, String password, AppRole role) {
        AppUser user = new AppUser(username, password, role);
        //appUserList = Stream.concat(appUserList, Stream.of(user));
        appUserList.add(user);
        return user;

    }

    @Override
    public AppUser findByUsername(String username) {
        //for(AppUser user : appUserList){
          //  if(user.getUsername().equals(username)){
            //    return user;
           // }
        //}
        return appUserList.stream().filter(user -> username.equals(user.getUsername())).findAny().orElse(null);
        //return appUserList.filter(user -> username.equals(user.getUsername())).findAny().orElse(null);
    }

    @Override
    public Collection<AppUser> findAll() {
        ArrayList<AppUser> list = new ArrayList<AppUser>(appUserList.stream().collect(Collectors.toList()));
        return list;
    }

    @Override
    public void remove(String username) {
        //for(AppUser user : appUserList){
        //if(user.getUsername().equals(username)){
        //appUserList.remove(user);
            //}
        //}
        appUserList = new ArrayList<>(appUserList.stream().filter(user -> !user.getUsername().equals(username)).collect(Collectors.toList()));
    }
}
