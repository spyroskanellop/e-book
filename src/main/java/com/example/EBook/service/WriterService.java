package com.example.EBook.service;

import com.example.EBook.model.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WriterService {
    List<Writer> getAllBooks();
    void saveWriter(Writer writer);
}
