package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        RoleDAO roleDAO = new RoleDAO();
        UserDAO userDAO = new UserDAO();

        Role role1 = new Role();
        role1.setAverageSalary(3050);
        role1.setProfession("milkmaid");
        role1 = roleDAO.insertRole(role1);

        Role role2 = new Role();
        role2.setAverageSalary(400000);
        role2.setProfession("killer");
        role2 = roleDAO.insertRole(role1);

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(role1);

        User user1 = new User();
        user1.setAge(20);
        user1.setEmail("beng@gmail.com");
        user1.setName("Kutropally");
        user1.setRoles(roles);
        user1 = userDAO.insertUser(user1);

        roles.add(role2);

        user1 = userDAO.updateUser(user1);

        User user = userDAO.selectUser(user1.getIdUser());
        user.getRoles();

        User user2 = new User();
        user2.setAge(20);
        user2.setEmail("sdf@uh.ru");
        user2.setName("Name");
        user2.setRoles(roles);

        userDAO.insertUser(user2);
        userDAO.deleteUser(user2);

        userDAO.insertUser(new User("Mimimi", 3, "www.LENINGRAD-SPB.ru"));
        userDAO.deleteUser(new User(10));
        System.out.println(userDAO.findAllUser());



    }
}
