package com.example.EBook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "writerId")
    private Writer writer;

    @Override
    public String toString() {
        return title+" ";
    }
}
