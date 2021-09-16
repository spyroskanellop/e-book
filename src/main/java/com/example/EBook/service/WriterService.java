package com.example.EBook.service;

import com.example.EBook.model.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WriterService {
    List<Writer> getAllWriters();
    void saveWriter(Writer writer);
    Writer findWriter(int id) throws WriterNotFoundException;
    void deleteWriter(int id) throws WriterNotFoundException;
}
