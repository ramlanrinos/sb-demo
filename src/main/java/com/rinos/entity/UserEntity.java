package com.rinos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    public UserEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
