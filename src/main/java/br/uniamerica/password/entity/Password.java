package br.uniamerica.password.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "passwords")
public class Password extends AbstractEntity {
    @Getter @Setter
    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    @Getter @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter @Setter
    @Column(name = "site", nullable = false)
    private String site;

    @Getter @Setter
    @Column(name = "password", nullable = false)
    private String password;
}
