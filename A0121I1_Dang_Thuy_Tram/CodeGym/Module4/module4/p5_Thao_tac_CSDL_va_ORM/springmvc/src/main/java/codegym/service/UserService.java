package codegym.service;

import codegym.entity.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    List<User> getListUser();
    void saveUser(User user);
    void editUser(User user);
    void deleteUser(User user);
    void saveOrEdit(User user);
}
