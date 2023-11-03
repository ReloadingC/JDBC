package org.example;

public interface UserService {
    void create(User user);
    User getByUserId(int id);
    void delete(int id);

    void editByUserId(int id, String username, String password);

    void getAllUsers();


}
