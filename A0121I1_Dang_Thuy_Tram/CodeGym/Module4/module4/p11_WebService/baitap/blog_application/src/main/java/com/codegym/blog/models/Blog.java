package com.codegym.blog.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titleBlog;
    private String descBlog;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
