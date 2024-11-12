package org.example.DAO;

import org.example.Person;

import java.util.Collection;

public interface PersonDAO {
    Person persist(String firstName, String lastName, String email);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<Person> findAll();
    void remove(int id);
}
