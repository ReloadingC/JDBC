package org.example;

public class SQLConstants {
    public final static String USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public final static String CREATE_USER = "INSERT INTO users(username, password) VALUES(?, ?)";
    public final static String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    public final static String EDIT_USER_BY_ID = "UPDATE users SET username = ?, password = ? WHERE id = ?";
    public final static String GET_ALL_USERS = "SELECT * FROM users";


}
