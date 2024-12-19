package org.example.DAO;

import org.example.Models.Person;
import org.example.sequencers.PersonIdSequencer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.example.db.MySQLConnection.getConnection;

public class PersonDAOCollection implements PersonDAO {
    private ArrayList<Person> personList = new ArrayList<>();

    @Override
    public Person create(String firstName, String lastName) {
        String sql = "INSERT INTO person (first_name, last_name) VALUES(?,?)";
        Person person = new Person(firstName,lastName);

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Person added");
            }

            try(ResultSet generatedKey = preparedStatement.getGeneratedKeys())
            {
                if(generatedKey.next()){
                    int generatedId = generatedKey.getInt(1);
                    person.setPerson_id(generatedId);
                }
            }
        }
        catch(SQLException e){
            e.getStackTrace();
        }
        return person;
        /*
        int id = PersonIdSequencer.nextId();
        personList.add(new Person(firstName, lastName, email, id));
        return personList.getLast();
         */
    }


    @Override
    public Person findById(int id) {
        String sql = "SELECT * FROM person WHERE person_id = ?";

        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Person person = new Person("Something", "Wrong");
            while(resultSet.next()){
                person.setPerson_id(resultSet.getInt("person_id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
            }
            return person;
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return null;
        /*
        for(Person person : personList){
            if(person.getId() == id){
                return person;
            }
        }
        return null;
         */
    }

    @Override
    public Collection<Person> findByName(String name) {
        String sql = "SELECT * FROM person WHERE first_name LIKE ?";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                personList.add(new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return personList;
    }

    /*
    @Override
    public Person findByEmail(String email) {
        for(Person person : personList){
            if(person.getEmail().equals(email)){
                return person;
            }
        }
        return null;
    }
    */

    @Override
    public Collection<Person> findAll() {
        String sql = "SELECT * FROM person";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                personList.add(new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return personList;
    }

    @Override
    public Person update(Person person) {
        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getId());

            preparedStatement.executeUpdate();
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return person;
    }

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM person WHERE person_id = ?";

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Person with id: " + id + " removed from db");
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        /*
        for(Person person : personList){
            if(person.getId() == id){
                personList.remove(person);
            }
        }
         */
    }
}
