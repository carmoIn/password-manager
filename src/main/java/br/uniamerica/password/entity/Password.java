package br.uniamerica.password.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
public class Password extends AbstractEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "site", nullable = false)
    private String site;

    @Column(name = "password", nullable = false)
    private String password;
}
