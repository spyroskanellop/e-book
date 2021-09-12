package com.example.EBook.service;

import com.example.EBook.model.Book;
import com.example.EBook.model.Writer;
import com.example.EBook.repository.BookRepository;
import com.example.EBook.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void saveBook(Book book) {
        this.bookRepository.save(book);
    }
}
