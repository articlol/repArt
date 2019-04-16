package com.company;

public class Role {
    private int id_role;
    private String profession;
    private  int average_salary;

    public Role(String profession, int average_salary) {
        this.profession = profession;
        this.average_salary = average_salary;
    }

    public Role(int id_role) {
        this.id_role = id_role;
    }

    public Role() {
        this.id_role = id_role;
        this.profession = profession;
        this.average_salary = average_salary;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    public int getAverage_salary() {
        return average_salary;
    }

    public void setAverage_salary(int average_salary) {
        this.average_salary = average_salary;
    }

    @Override
    public String toString() {
        return "Role (profession = " + this.profession +
                ", average salary = " + this.average_salary + ")" + "\n";
    }
}
