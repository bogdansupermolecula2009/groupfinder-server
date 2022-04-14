package ru.heavyproject.groupfinder.server.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "role_id")
    private Long role_id;
    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    @Override
    public String getAuthority() {
        return getName();
    }
}
