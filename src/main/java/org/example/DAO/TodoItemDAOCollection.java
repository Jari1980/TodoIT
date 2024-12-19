package org.example.DAO;

import org.example.Models.Person;
import org.example.Models.Todo_item;
import org.example.sequencers.TodoItemIdSequencer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static java.sql.Types.NULL;
import static org.example.db.MySQLConnection.getConnection;

public class TodoItemDAOCollection implements TodoItemDAO {
    private ArrayList<Todo_item> todoItemList = new ArrayList<>();


    /*
    @Override
    public Todo_item persist(String title, String taskDescription, LocalDate deadline, boolean done, Person creator) {
        int id = TodoItemIdSequencer.nextId();
        todoItemList.add(new Todo_item(title, taskDescription, deadline, done, creator, id));
        return todoItemList.getLast();
    }
     */
    @Override
    public Todo_item create(Todo_item todo_item) {

        String sql = "INSERT INTO todo_item (title, description, deadline, done, assignee_id) VALUES(?,?,?,?,?)";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            preparedStatement.setString(1, todo_item.getTitle());
            preparedStatement.setString(2, todo_item.getTaskDescription());
            preparedStatement.setDate(3, java.sql.Date.valueOf(todo_item.getDeadline()));
            preparedStatement.setBoolean(4, todo_item.isDone());
            if(todo_item.getCreator() != null){
                preparedStatement.setInt(5, todo_item.getCreator().getId());
            }
            else{
                preparedStatement.setNull(5, NULL);
            }

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Person added");
            }

            try(ResultSet generatedKey = preparedStatement.getGeneratedKeys())
            {
                if(generatedKey.next()){
                    int generatedId = generatedKey.getInt(1);
                    todo_item.setTodo_id(generatedId);
                    return todo_item;
                }
            }
        }
        catch(SQLException e){
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public Todo_item findById(int id) {
        String sql = "SELECT * FROM todo_item WHERE todo_id = ?";
        PersonDAOCollection creator = new PersonDAOCollection();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Todo_item todoItem = new Todo_item(resultSet.getString("title"), resultSet.getString("description"),
                        LocalDate.parse(resultSet.getString("deadline")), resultSet.getBoolean("done"),
                        creator.findById(resultSet.getInt("assignee_id")), resultSet.getInt("todo_id"));
                return  todoItem;
            }
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return null;

        /*
        for(Todo_item todo : todoItemList){
            if(todo.getId() == id){
                return todo;
            }
        }
        return null;
         */
    }

    @Override
    public Collection<Todo_item> findAll() {
        String sql = "SELECT * FROM todo_item";
        PersonDAOCollection creator = new PersonDAOCollection();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                todoItemList.add(new Todo_item(("title"), resultSet.getString("description"),
                        LocalDate.parse(resultSet.getString("deadline")), resultSet.getBoolean("done"),
                        creator.findById(resultSet.getInt("assignee_id")), resultSet.getInt("todo_id")));
            }
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return todoItemList;
    }

    @Override
    public Collection<Todo_item> findByDoneStatus(boolean done) {
        String sql = "SELECT * FROM todo_item WHERE done = ?";
        PersonDAOCollection creator = new PersonDAOCollection();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setBoolean(1, done);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                todoItemList.add(new Todo_item(("title"), resultSet.getString("description"),
                        LocalDate.parse(resultSet.getString("deadline")), resultSet.getBoolean("done"),
                        creator.findById(resultSet.getInt("assignee_id")), resultSet.getInt("todo_id")));
            }
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return todoItemList;
    }

    /*
    @Override
    public Collection<Todo_item> findByTitleContains(String title) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getTitle().contains(title)){
                temp.add(item);
            }
        }
        return temp;
    }

     */

    @Override
    public Collection<Todo_item> findByAssignee(int personId) {
        String sql = "SELECT * FROM todo_item WHERE assignee_id = ?";
        PersonDAOCollection creator = new PersonDAOCollection();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                todoItemList.add(new Todo_item(resultSet.getString("title"), resultSet.getString("description"),
                        LocalDate.parse(resultSet.getString("deadline")), resultSet.getBoolean("done"),
                        creator.findById(resultSet.getInt("assignee_id")), resultSet.getInt("todo_id")));
            }
            return todoItemList;
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return null;
        /*
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getCreator().getId() == personId){
                temp.add(item);
            }
        }
        return temp;
         */
    }

    @Override
    public Collection<Todo_item> findByAssignee(Person person) {
        String sql = "SELECT * FROM todo_item WHERE assignee_id = ?";
        PersonDAOCollection creator = new PersonDAOCollection();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1, person.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                todoItemList.add(new Todo_item(resultSet.getString("title"), resultSet.getString("description"),
                        LocalDate.parse(resultSet.getString("deadline")), resultSet.getBoolean("done"),
                        creator.findById(resultSet.getInt("assignee_id")), resultSet.getInt("todo_id")));
            }
            return todoItemList;
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return null;
    }

    @Override
    public Collection<Todo_item> findByUnassignedTodoItems() {
        String sql = "SELECT * FROM todo_item WHERE assignee_id IS Null";
        PersonDAOCollection creator = new PersonDAOCollection();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                todoItemList.add(new Todo_item(resultSet.getInt("todo_id"), resultSet.getString("title"), resultSet.getString("description"),
                        LocalDate.parse(resultSet.getString("deadline")), resultSet.getBoolean("done")));
            }
            return todoItemList;
        }
        catch(SQLException e){
            e.getStackTrace();
        }

        return null;
    }

    @Override
    public Todo_item update(Todo_item todo_item) {
        String sql = "UPDATE todo_item SET title = ?, description = ?, deadline = ?, done = ?, assignee_id = ? WHERE todo_id = ?";
        PersonDAOCollection assignee = new PersonDAOCollection();

        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setString(1, todo_item.getTitle());
            statement.setString(2, todo_item.getTaskDescription());
            statement.setDate(3, java.sql.Date.valueOf(todo_item.getDeadline()));
            statement.setBoolean(4, todo_item.isDone());
            statement.setInt(5, assignee.findById(todo_item.getCreator().getId()).getId());  //todo_item.getCreator().getId());
            statement.setInt(6, todo_item.getId());



            statement.executeUpdate();

        }
        catch(SQLException e){
            e.getStackTrace();
        }
        return todo_item;
    }

    /*
    @Override
    public Collection<Todo_item> findByDeadlineBefore(LocalDate date) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getDeadline().isBefore(date)){
                temp.add(item);
            }
        }
        return temp;
    }

    @Override
    public Collection<Todo_item> findByDeadLineAfter(LocalDate date) {
        ArrayList<Todo_item> temp = new ArrayList<>();
        for(Todo_item item : todoItemList){
            if(item.getDeadline().isAfter(date)){
                temp.add(item);
            }
        }
        return temp;
    }
     */

    @Override
    public void remove(int id) {
        String sql = "DELETE FROM todo_item WHERE todo_id = ?";
        try(
                Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
        ){
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("todo_item with id: " + id + ", removed");
        }
        catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
