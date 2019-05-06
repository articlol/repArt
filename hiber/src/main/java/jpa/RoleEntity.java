package jpa;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private int idRole;
    private String profession;

    @Column(name = "average_salary")
    private int averageSalary;
    @ManyToMany
    @JoinTable(name = "role",
            joinColumns = @JoinColumn(name = "id_role"),
            inverseJoinColumns = @JoinColumn(name = "id_users"))
    private List<UserEntity> users;

    public RoleEntity() {
    }

    public RoleEntity(String profession, int averageSalary, List<UserEntity> users) {
        this.profession = profession;
        this.averageSalary = averageSalary;
        this.users = users;
    }

    public int getIdRole() {
        return idRole;
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

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role (profession = " + this.profession +
                ", average salary = " + this.averageSalary + ")" + "\n";
    }
}