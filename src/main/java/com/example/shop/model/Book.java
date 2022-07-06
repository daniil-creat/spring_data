package com.example.shop.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name = "coast")
    private Integer coast;

    @ManyToMany(cascade = { CascadeType.DETACH })
    @JoinTable(
            name = "books_authors",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") })
    private List<Author> authors;
}
