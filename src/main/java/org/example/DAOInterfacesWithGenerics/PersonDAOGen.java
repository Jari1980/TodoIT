package org.example.DAOInterfacesWithGenerics;

import org.example.Models.Person;

import java.util.Collection;

public interface PersonDAOGen<E> {
    Person persist(String firstName, String lastName, String email);
    Person findById(int id);
    Person findByEmail(String email);
    Collection<E> findAll();
    void remove(int id);
}
