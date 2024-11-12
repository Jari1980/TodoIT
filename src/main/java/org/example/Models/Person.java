
package org.example.Models;


//import jakarta.validation.constraints.NotNull;

import org.example.sequencers.PersonIdSequencer;

import java.util.Objects;

public class Person {
    //private static int counter = 1;
    private int id;
    //@NotNull
    private String firstName;
    //@NotNull
    private String lastName;
    //@NotNull
    private String email;
    private String credentials;

    public Person(String firstName, String lastName, final String email){
        this.firstName = Objects.requireNonNull(firstName, "No null firstname!");
        this.lastName = Objects.requireNonNull(lastName, "No null lastname!");
        this.email = Objects.requireNonNull(email, "No null email!");
        //this.id = counter++;
        this.id = PersonIdSequencer.nextId();
    }

    @Override
    public String toString(){
        //System.out.println("id: " + id + "\nname: " + firstName + " " + lastName + "\nemail: " + email);
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("\nname: ");
        sb.append(firstName);
        sb.append(" ");
        sb.append(lastName);
        sb.append("\nemail: ");
        sb.append(email);
        return sb.toString();
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }
    public String getCredentials(){
        return credentials;
    }

    //public void setId(int id) {  //Removing this since id is set automatic
    //    this.id = id;
    //}

    public void setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName, "No change to null firstname!");;
    }
    public void setLastName(String lastName) {
        this.lastName = Objects.requireNonNull(lastName, "No change to null lastname!");;
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
        return id == person.id && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
