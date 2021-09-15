package com.example.EBook.service;

import com.example.EBook.model.Book;
import com.example.EBook.model.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
    Book findBook(int id) throws BookNotFoundException;
    void deleteBook(Integer id) throws BookNotFoundException;
}
