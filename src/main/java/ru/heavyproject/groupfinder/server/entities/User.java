package ru.heavyproject.groupfinder.server.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "user_t")
@Data
public class User implements UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
