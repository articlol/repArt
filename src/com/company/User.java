package com.company;

public class User {
    private int id_user;
    private String name;
    private int age;
    private String email;

    public User(int id_user) {
        this.id_user = id_user;
    }

    public User() {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId_users() {
        return id_user;
    }

    public void setId_users(int id_users) {
        this.id_user = id_users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User(name = " + this.name +
                ", age = " + this.age +
                ", email = " + this.email + ")" + "\n";
    }
}
