package org.example;

import java.util.Collection;

public interface AppUserDAO {
    AppUser persist(String username, String password, AppRole role);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void remove(String username);
}
