package com.example.EBook.controller;

import com.example.EBook.model.Book;
import com.example.EBook.model.Writer;
import com.example.EBook.service.BookNotFoundException;
import com.example.EBook.service.WriterNotFoundException;
import com.example.EBook.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WriterController {
    @Autowired
    WriterService writerService;

    @GetMapping("/")
    public String homePage(Model model){
        List<Writer> writer = writerService.getAllWriters();
        model.addAttribute("writerList", writerService.getAllWriters());
        return "index";
    }
    @GetMapping("/showNewWriterForm")
    public String showNewWriterForm(Model model){
        Writer writer = new Writer();
        model.addAttribute("pageTitle", "Add New Writer");
        model.addAttribute("writer", writer);
        return "new_writer";
    }
    @PostMapping("/saveWriter")
    public String saveWriter(@ModelAttribute("writer") Writer writer, RedirectAttributes redirectAttributes){
        writerService.saveWriter(writer);
        redirectAttributes.addFlashAttribute("message", "Writer saved successfully");
        return "redirect:/";
    }
    @GetMapping("/editWriter/{id}")
    public String editWriter(@PathVariable("id") int id, RedirectAttributes redirectAttributes, Model model){
        try {
            Writer writer = writerService.findWriter(id);
            model.addAttribute("writer", writer);
            model.addAttribute("pageTitle", "Edit Writer (ID "+ id +")");
            return "new_writer";
        } catch (WriterNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:/";
        }
    }
    @GetMapping("/deleteWriter/{id}")
    public String deleteWriter(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        try{
            writerService.deleteWriter(id);
            redirectAttributes.addFlashAttribute("message", "Writer has been deleted");
        }catch(WriterNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/";
    }
    @GetMapping("/goBook")
    public String goToBook(){
        return "redirect:/book/viewBooks";
    }
}
