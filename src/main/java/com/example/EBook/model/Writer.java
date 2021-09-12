package com.example.EBook.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "writer")
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int writerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

//    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "BookList", referencedColumnName = "bookId")
//    private Collection<Book> bookCollection;
}
