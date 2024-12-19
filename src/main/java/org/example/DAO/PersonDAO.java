package org.example.DAO;

import org.example.Models.Person;

import java.util.Collection;

public interface PersonDAO {
    Person create(String firstName, String lastName); // refactored persist -> create
    Person findById(int id);
    // Person findByEmail(String email); //Not used in new refactor
    Collection<Person> findByName(String name); //Added
    Collection<Person> findAll();
    Person update(Person person); //Added in new refactor
    void remove(int id);
}
