package jpa;


import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        UserEntity numberOne = new UserEntity();
        numberOne.setName("Zelenskiy");
        numberOne.setAge(38);
        numberOne.setEmail("iampresident@pr.ru");

        ArrayList<UserEntity> users = new ArrayList<>();
        users.add(numberOne);

        RoleEntity president = new RoleEntity();
        president.setProfession("president");
        president.setAverageSalary(9999999);

        new UserDAOEntity().insertUser(numberOne);
        new RoleDAOEntity().insertRole(president);


    }
}
