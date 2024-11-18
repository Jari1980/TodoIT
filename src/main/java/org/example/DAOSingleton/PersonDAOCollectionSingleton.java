package org.example.DAOSingleton;

import org.example.DAO.PersonDAO;
import org.example.DAOInterfacesWithGenerics.PersonDAOGen;
import org.example.Models.Person;
import org.example.sequencers.PersonIdSequencer;
import org.example.sequencers.TodoItemIdSequencer;

import java.util.ArrayList;
import java.util.Collection;

public final class PersonDAOCollectionSingleton implements PersonDAOGen<Person> {
    private static PersonDAOCollectionSingleton INSTANCE;
    private ArrayList<Person> personList = new ArrayList<>();

    public static PersonDAOCollectionSingleton getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new PersonDAOCollectionSingleton();
        }
        return INSTANCE;
    }

    @Override
    public Person persist(String firstName, String lastName, String email) {
        int id = PersonIdSequencer.nextId();
        personList.add(new Person(firstName, lastName, email, id));
        return personList.getLast();
    }

    @Override
    public Person findById(int id) {
        for(Person person : personList){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for(Person person : personList){
            if(person.getEmail().equals(email)){
                return person;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findAll() {
        return personList;
    }

    @Override
    public void remove(int id) {
        for(Person person : personList){
            if(person.getId() == id){
                personList.remove(person);
            }
        }
    }
}
