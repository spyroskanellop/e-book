package com.example.EBook.service;

import com.example.EBook.model.Writer;
import com.example.EBook.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterServiceImpl implements WriterService{
    @Autowired
    private WriterRepository writerRepository;

    @Override
    public List<Writer> getAllBooks() {
        return writerRepository.findAll();
    }

    @Override
    public void saveWriter(Writer writer) {
        this.writerRepository.save(writer);
    }
}
