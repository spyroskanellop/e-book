package com.example.EBook.controller;

import com.example.EBook.model.Writer;
import com.example.EBook.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WriterController {
    @Autowired
    WriterService writerService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("writerList", writerService.getAllBooks());
        return "index";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/showNewWriterForm")
    public String showNewWriterForm(Model model){
        Writer writer = new Writer();
        model.addAttribute("writer", writer);
        return "new_writer";
    }
    @PostMapping("/saveWriter")
    public String saveWriter(@ModelAttribute("writer") Writer writer){
        writerService.saveWriter(writer);
        return "redirect:/";
    }
}
