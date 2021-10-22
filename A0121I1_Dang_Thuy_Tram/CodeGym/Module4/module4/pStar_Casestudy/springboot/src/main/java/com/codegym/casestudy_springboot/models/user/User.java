package com.codegym.casestudy_springboot.models.user;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class User {
    @Id
    private String username;
    private String password;



}
