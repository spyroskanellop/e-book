package com.example.EBook.service;

import com.example.EBook.model.Book;
import com.example.EBook.model.Writer;
import com.example.EBook.repository.BookRepository;
import com.example.EBook.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public Book findBook(int id) throws BookNotFoundException {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        } else {
            throw new BookNotFoundException("The requested book cannot found");
        }
    }

    @Override
    public void deleteBook(Integer id) throws BookNotFoundException {
        Long count = bookRepository.countByBookId(id);
        if(count == null || count == 0){
            throw new BookNotFoundException("No book with such id");
        } else{
            bookRepository.deleteById(id);
        }
    }
}
