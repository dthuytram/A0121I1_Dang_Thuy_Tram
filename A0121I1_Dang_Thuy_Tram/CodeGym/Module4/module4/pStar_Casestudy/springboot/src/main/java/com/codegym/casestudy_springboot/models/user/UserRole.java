package com.codegym.casestudy_springboot.models.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserRole {

    @EmbeddedId
    private UserRoleKey id;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name = "username")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    private Role role;
}
