package com.company;

import java.util.List;

public class User {
    private int idUser;
    private String name;
    private int age;
    private String email;

    private List<Role> roles;

    public User(int idUser) {
        this.idUser = idUser;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    public List<Role> getRoles() { return roles; }

    public void setRoles(List<Role> roles) { this.roles = roles; }

    @Override
    public String toString() {
        return "User(name = " + this.name +
                ", age = " + this.age +
                ", email = " + this.email + ")" + "\n";
    }
}
