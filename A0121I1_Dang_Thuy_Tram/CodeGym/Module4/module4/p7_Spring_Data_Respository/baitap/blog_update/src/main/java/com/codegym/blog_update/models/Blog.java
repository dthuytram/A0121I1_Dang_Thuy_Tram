package com.codegym.blog_update.models;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titleBlog;
    private String descBlog;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

}
