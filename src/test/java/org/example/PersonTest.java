package org.example;


import org.example.Models.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    //Testing constructur
    @Test
    void createPersonNonNullTest(){
        Person person = new Person("Jari", "Testar", "test@test");
        int constructorIdTest = person.getId();
        assertEquals(person.toString(), "id: " + constructorIdTest + "\nname: Jari Testar" + "\nemail: test@test");
    }
    @Test
    void createPersonNullFirstName(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            Person person = new Person(null, "Testar", "test@test");
        });
    }
    @Test
    void createPersonNullLastName(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            Person person = new Person("Jari", null, "test@test");
        });
    }
    @Test
    void createPersonNullEmail(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            Person person = new Person("Jari", "Testar", null);
        });
    }

    //Testing setters and getters
    Person personSetGet = new Person("Jari", "Testar", "test@test");

    @Test
    void setFirstNameNonNull(){
        personSetGet.setFirstName("Billy");
        assertEquals(personSetGet.getFirstName(), "Billy");
    }
    @Test
    void setFirstNameNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            personSetGet.setFirstName(null);
        });
    }
    @Test
    void setLastNameNonNull(){
        personSetGet.setLastName("mmm");
        assertEquals(personSetGet.getLastName(), "mmm");
    }
    @Test
    void setLastNameNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            personSetGet.setLastName(null);
        });
    }
    @Test
    void setEmailNonNull(){
        personSetGet.setEmail("mmm");
        assertEquals(personSetGet.getEmail(), "mmm");
    }
    @Test
    void setEmailNull(){
        Assertions.assertThrowsExactly(NullPointerException.class, () -> {
            personSetGet.setEmail(null);
        });
    }
    @Test
    void getFirstNameTest(){
        assertEquals(personSetGet.getFirstName(), "Jari");
    }
    @Test
    void getLastNameTest(){
        assertEquals(personSetGet.getLastName(), "Testar");
    }
    @Test
    void getEmailTest(){
        assertEquals(personSetGet.getEmail(), "test@test");
    }

    /*
    //Testing method
    @Test
    void getSummary(){
        Person personSummary = new Person("Jari", "Testar", "test@test");
        String testSummary = personSummary.toString();
        int personId = personSummary.getId();
        String expectedSummary = "id: " + personId + "\nname: Jari Testar" + "\nemail: test@test";
        assertEquals(testSummary,expectedSummary);
    }

     */
}