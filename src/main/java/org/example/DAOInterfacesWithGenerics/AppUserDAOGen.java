package org.example.DAOInterfacesWithGenerics;

import org.example.Models.AppRole;
import org.example.Models.AppUser;

import java.util.ArrayList;
import java.util.Collection;

public interface AppUserDAOGen<E> {
    AppUser persist(String username, String password, AppRole role);
    AppUser findByUsername(String username);
    Collection<E> findAll();
    void remove(String username);
}
