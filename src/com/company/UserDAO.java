package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private final ConnectorDB connectorDB;
    private  static UserDAO instance = new UserDAO();
    public UserDAO(){ this.connectorDB = ConnectorDB.getInstance(); }
    public static UserDAO getInstance(){return instance;}

    public List<User> findAllUser()  {
        List<User> list = new ArrayList<>();

        try (Connection connection = connectorDB.openConnection();
             PreparedStatement prst = connection.prepareStatement(
                     "select * from users")) {
            ResultSet resultSet = prst.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                list.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public User selectUser (int idUser){
        try(Connection connection = connectorDB.openConnection();
            PreparedStatement prst = connection.prepareStatement(
                    "select name, age, email from users where id_users = ?");) {
            prst.setInt(1, idUser);
            ResultSet resultSet = prst.executeQuery();
            if(resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                User user = new User();
                user.setName(name);
                user.setAge(age);
                user.setEmail(email);
                return user;
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public User updateUser(User user){
        try (Connection connection = connectorDB.openConnection();
             PreparedStatement prst = connection.prepareStatement(
                     "update users set name = ?, age = ?, email = ? ")) {
            prst.setString(1, user.getName());
            prst.setInt(2, user.getAge());
            prst.setString(3, user.getEmail());
            prst.executeUpdate();
            return user;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public User insertUser(User user){
        try(Connection connection = connectorDB.openConnection();
            PreparedStatement prst = connection.prepareStatement(
                    "insert into users(name, age, email) values(?, ?, ?)")) {
            prst.setString(1, user.getName());
            prst.setInt(2, user.getAge());
            prst.setString(3, user.getEmail());
            prst.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return user;
    }
    public void deleteUser(User user) {
        try(Connection connection = connectorDB.openConnection();
        PreparedStatement prst = connection.prepareStatement(
                "delete from users where id_users = ?")) {
            prst.setInt(1, user.getIdUser());
            prst.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void addUserRole (String name, String profession){
        try(Connection connection = connectorDB.openConnection();
            PreparedStatement prst = connection.prepareStatement(
                    "insert into users_role (id_pivot_users, id_pivot_role)" +
                            "select users.id_users, role.id_role" +
                            "from users, role" +
                            "where users.name = ? and role.profession = ?")){
            prst.setString(1, name);
            prst.setString(2, profession);

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
