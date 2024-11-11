package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonDAOCollection implements  PersonDAO{
    private ArrayList<Person> personList = new ArrayList<>();

    @Override
    public Person persist(String firstName, String lastName, String email) {
        personList.add(new Person(firstName, lastName, email));
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
