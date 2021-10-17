package com.example.pageable_search.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private int id;

    private String type;

    private String author;

    @ManyToOne(targetEntity = )


}
