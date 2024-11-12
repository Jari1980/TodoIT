package org.example.DAO;

import org.example.Models.AppRole;
import org.example.Models.AppUser;

import java.util.Collection;

public interface AppUserDAO {
    AppUser persist(String username, String password, AppRole role);
    AppUser findByUsername(String username);
    Collection<AppUser> findAll();
    void remove(String username);
}
