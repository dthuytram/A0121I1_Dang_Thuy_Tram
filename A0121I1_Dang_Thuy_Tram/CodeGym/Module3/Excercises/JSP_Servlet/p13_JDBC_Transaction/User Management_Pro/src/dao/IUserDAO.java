package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id) throws SQLException ;

    public List<User> selectAllUsers() throws SQLException;

    public List<User> selectCountryUsers(String country) throws SQLException;

    public List<User> sortAllUsers() throws SQLException;

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public User getUserById(int id) throws SQLException;

    public void insertUserStore(User user) throws SQLException;

    public void addUserTransaction(User user, int[] permisions);

    public void insertUpdateWithoutTransaction() throws SQLException;
    public void insertUpdateUseTransaction() throws SQLException;
}
