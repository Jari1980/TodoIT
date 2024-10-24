
package org.example;


//import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class Person {
    private static int counter = 1;
    private int id;
    //@NotNull
    private String firstName;
    //@NotNull
    private String lastName;
    //@NotNull
    private String email;

    public Person(String firstName, String lastName, final String email){
        this.firstName = Objects.requireNonNull(firstName, "No null firstname!");
        this.lastName = Objects.requireNonNull(lastName, "No null lastname!");
        this.email = Objects.requireNonNull(email, "No null email!");
        this.id = counter++;
    }

    public void getSummary(){
        System.out.println("id: " + id + "\nname: " + firstName + " " + lastName + "\nemail: " + email);
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
}
