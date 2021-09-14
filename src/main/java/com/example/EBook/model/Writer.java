package com.example.EBook.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    private List<Book> bookList;

    @Override
    public String toString() {
        return firstName +" "+ lastName;
    }
}
