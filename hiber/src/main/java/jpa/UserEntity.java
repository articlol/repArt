package jpa;


import javax.management.relation.Role;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_users")
    private int idUser;
    private String name;
    private int age;
    private String email;

    @ManyToMany
    @JoinTable(name = "users",
            joinColumns = @JoinColumn(name = "id_users"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RoleEntity> roles;

    public UserEntity() {
    }

    public UserEntity(String name, int age, String email, List<RoleEntity> roles) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.roles = roles;
    }

    public int getIdUser() {
        return idUser;
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

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User(name = " + this.name +
                ", age = " + this.age +
                ", email = " + this.email + ")" + "\n";
    }
}