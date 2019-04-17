package com.company;

import java.util.List;

public class Role {
    private int idRole;
    private String profession;
    private  int averageSalary;

    private List<User> users;

    public Role(String profession, int averageSalary) {
        this.profession = profession;
        this.averageSalary = averageSalary;
    }

    public Role(int idRole) {
        this.idRole = idRole;
    }

    public Role() {
        this.idRole = idRole;
        this.profession = profession;
        this.averageSalary = averageSalary;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    public int getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(int averageSalary) {
        this.averageSalary = averageSalary;
    }

    public List<User> getUsers() { return users; }

    public void setUsers(List<User> users) { this.users = users; }

    @Override
    public String toString() {
        return "Role (profession = " + this.profession +
                ", average salary = " + this.averageSalary + ")" + "\n";
    }
}
