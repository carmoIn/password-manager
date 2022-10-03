package br.uniamerica.password.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "users")
public class User extends AbstractEntity implements UserDetails {
    @Getter @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Getter @Setter
    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User(
            String name,
            String username,
            String password,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public static User build(final User user) {
        User currentUser = new User();
        currentUser.setName(user.getName());
        currentUser.setActive(user.isActive());
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());

        return currentUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return this.isActive();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return this.isActive();
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return this.isActive();
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return this.isActive();
    }
}
