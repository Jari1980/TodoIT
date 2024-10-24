package org.example;


public class Main {
    public static void main(String[] args) {

        //Testing - Seems to work, cant set fields to null without error and message
        Person test = new Person("Jari", "Testar", "epost");
        test.getSummary();
        Person test2 = new Person("Test", "igen då", "mm");
        test2.setEmail("kk");
        test2.getSummary();


    }
}