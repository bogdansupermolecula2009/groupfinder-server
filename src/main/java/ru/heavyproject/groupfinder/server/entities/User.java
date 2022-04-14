package ru.heavyproject.groupfinder.server.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_t")
public class User {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name="password", nullable=false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "owner")
    private Set<Group> groups;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role>roles;

}
