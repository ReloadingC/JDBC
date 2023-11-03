package org.example;

import java.sql.*;

import static org.example.JDBCConnection.getConnection;
import static org.example.SQLConstants.*;

public class UserServiceImpl implements UserService {

    @Override
    public void create(User user) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException();
        }


    }

    @Override
    public User getByUserId(int id) {
        Connection connection = getConnection();
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_ID);
            preparedStatement.setString(1, String.valueOf(id));

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        }catch (SQLException e) {
            throw new RuntimeException();
        }

        return user;
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException();
        }


    }

    @Override
    public void editByUserId(int id, String username, String password) {
        Connection connection = getConnection();
        User user = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(EDIT_USER_BY_ID);
            preparedStatement.setInt(3,1);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);


            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        }catch (SQLException e) {
            throw new RuntimeException();
        }



    }

    @Override
    public void getAllUsers() {
        Connection connection = getConnection();


        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                System.out.println("ID: " + id + ", Name: " + name + ", Password: " + password + "\n");


            }
        }catch (SQLException e) {
            throw new RuntimeException();
        }


    }

    }



