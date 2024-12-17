
package org.example.Models;


//import jakarta.validation.constraints.NotNull;

import org.example.sequencers.PersonIdSequencer;

import java.util.Objects;

public class Person {
    //private static int counter = 1;
    private int person_id; //Refactored id -> person_id
    //@NotNull
    private String first_name; //Refactored firstName -> first_name
    //@NotNull
    private String last_name; //Refactored lastName -> last_name
    //@NotNull
    private String email;
    private String credentials;

    public Person(String firstName, String lastName, final String email, int id){
        this.first_name = Objects.requireNonNull(firstName, "No null firstname!");
        this.last_name = Objects.requireNonNull(lastName, "No null lastname!");
        this.email = Objects.requireNonNull(email, "No null email!");
        this.person_id = id;
        //this.id = PersonIdSequencer.nextId();
    }



    @Override
    public String toString(){
        //System.out.println("id: " + id + "\nname: " + firstName + " " + lastName + "\nemail: " + email);
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(person_id);
        sb.append("\nname: ");
        sb.append(first_name);
        sb.append(" ");
        sb.append(last_name);
        sb.append("\nemail: ");
        sb.append(email);
        return sb.toString();
    }

    public String getFirstName() {
        return first_name;
    }
    public String getLastName() {
        return last_name;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return person_id;
    }
    public String getCredentials(){
        return credentials;
    }

    //public void setId(int id) {  //Removing this since id is set automatic
    //    this.id = id;
    //}

    public void setFirstName(String firstName) {
        this.first_name = Objects.requireNonNull(firstName, "No change to null firstname!");;
    }
    public void setLastName(String lastName) {
        this.last_name = Objects.requireNonNull(lastName, "No change to null lastname!");;
    }
    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email, "No change to null email!");;
    }
    public void setCredentials(String credentials){
        this.credentials = credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return person_id == person.person_id && Objects.equals(first_name, person.first_name) && Objects.equals(last_name, person.last_name) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, first_name, last_name, email);
    }
}
