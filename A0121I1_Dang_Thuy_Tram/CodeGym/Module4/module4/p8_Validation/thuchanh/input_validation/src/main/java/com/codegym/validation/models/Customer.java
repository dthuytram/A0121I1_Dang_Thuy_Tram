package com.codegym.validation.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Not null")
    @Size(min = 2, max = 30, message = "2-30 kí tự")
    private String firstName;

    @NotEmpty(message = "Not null")
    @Size(min = 2, max = 30,message = "2-30 kí tự")
    private String lastName;

    @Min(value = 18, message = "Không đủ 18 tuổi")
    private int age;


}