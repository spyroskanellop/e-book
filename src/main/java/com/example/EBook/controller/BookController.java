package com.example.EBook.controller;

import com.example.EBook.model.Book;
import com.example.EBook.repository.BookRepository;
import com.example.EBook.service.BookNotFoundException;
import com.example.EBook.service.BookService;
import com.example.EBook.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    WriterService writerService;


    @GetMapping("/viewBooks")
    public String getBooks(Model model){
        model.addAttribute("bookList", bookService.getAllBooks());
        return "bookList";
    }
    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("writerList", writerService.getAllWriters());
        model.addAttribute("pageTitle", "Add New Book");
        return "new_book";
    }
    @PostMapping("/saveBook")
    public String saveBook(Book book, RedirectAttributes redirectAttributes){
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("message", "Book saved successfully");
        return "redirect:/book/viewBooks";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes){
        try {
            Book book = bookService.findBook(id);
            model.addAttribute("book", book);
            model.addAttribute("pageTitle", "Edit User (ID "+ id +")");
            return "new_book";
        } catch (BookNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/book/viewBooks";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        try {
            bookService.deleteBook(id);
            redirectAttributes.addFlashAttribute("message", "Book has been deleted");
        } catch (BookNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/book/viewBooks";
    }
    @GetMapping("/")
    public String goToWriter(){return "redirect:/";}
}
