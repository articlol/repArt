package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException {
        RoleDAO roleDAO = new RoleDAO();
        UserDAO testUser = new UserDAO();
        testUser.insertUser(new User("Mimimi", 3, "www.LENINGRAD-SPB.ru"));
        testUser.deleteUser(new User(10));
        System.out.println(testUser.findAllUser());



    }
}
