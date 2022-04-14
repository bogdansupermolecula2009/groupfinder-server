package ru.heavyproject.groupfinder.server.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_t")
public class Person {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "age")
    private String age;

    @ManyToMany
    private Set<Group> groups;

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
