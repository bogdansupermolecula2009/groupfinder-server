package ru.heavyproject.groupfinder.server.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "group_t")
public class Group {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Id

    @ManyToMany
    private Set<Person> users;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Person> getUsers() {
        return users;
    }

    public void setUsers(Set<Person> users) {
        this.users = users;
    }
}
