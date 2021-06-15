package application.dao;

import application.Entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public void addUser(User user);
    public User show(int id);
    public void updateUser (int id, User user);
    public void deleteUser(int id);
}
