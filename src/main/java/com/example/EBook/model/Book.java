package com.example.EBook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @OneToOne(targetEntity = Writer.class)
    @JoinColumn(name = "writer", referencedColumnName = "writerId")
    private Writer writer;

    @Override
    public String toString() {
        return name+" ";
    }
}
