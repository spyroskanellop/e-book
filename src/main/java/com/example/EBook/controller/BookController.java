package com.example.EBook.controller;

import com.example.EBook.model.Book;
import com.example.EBook.repository.BookRepository;
import com.example.EBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/viewBooks")
    public String getBooks(Model model){
        model.addAttribute("bookList", bookService.getAllBooks());
        return "bookList";
    }
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }
    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:viewBooks";
    }
}
