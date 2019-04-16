package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
    private final ConnectorDB connectorDB;
    private  static RoleDAO instance = new RoleDAO();
    public RoleDAO(){ this.connectorDB = ConnectorDB.getInstance(); }
    public static RoleDAO getInstance(){return instance;}

    public List<Role> findAllRole() {
        List<Role> list = new ArrayList<>();

        try (Connection connection = connectorDB.openConnection();
             PreparedStatement prst = connection.prepareStatement(
                     "select * from role"))
        {
            ResultSet resultSet = prst.executeQuery();
            while (resultSet.next()) {
                Role role = new Role();
                role.setProfession(resultSet.getString("profession"));
                role.setAverage_salary(resultSet.getInt("average_salary"));
                list.add(role);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return list;
    }
    public Role selectRole(int id_role){
        try(Connection connection = connectorDB.openConnection();
        PreparedStatement prst = connection.prepareStatement("select profession, average_salary from role where id_role = ?"))
        {
            prst.setInt(1, id_role);
            ResultSet resultSet = prst.executeQuery();
            while (resultSet.next()) {
                String profession = resultSet.getString("profession");
                int average_profession = resultSet.getInt("average_salary");
                Role role = new Role();
                role.setProfession(profession);
                return role;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public Role updateRole(Role role){
        try(Connection connection = connectorDB.openConnection();
            PreparedStatement prst = connection.prepareStatement("update role set profession = ?, average_salary = ?"))
        {
            prst.setString(1, role.getProfession());
            prst.setInt(2, role.getAverage_salary());
            prst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return role;
    }
    public void insertRole(Role role){
        try(Connection connection = connectorDB.openConnection();
        PreparedStatement prst = connection.prepareStatement("insert into role(profession, average_salary) values(?, ?)"))
        {
            prst.setString(1, role.getProfession());
            prst.setInt(2, role.getAverage_salary());
            prst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void deleteRole(Role role){
        try(Connection connection = connectorDB.openConnection();
        PreparedStatement prst = connection.prepareStatement("delete from role where id_role = ?"))
        {
            prst.setInt(1, role.getId_role());
            prst.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
