package com.example.EBook.service;

import com.example.EBook.model.Writer;
import com.example.EBook.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterServiceImpl implements WriterService{
    @Autowired
    private WriterRepository writerRepository;

    @Override
    public List<Writer> getAllWriters() {
        return writerRepository.findAll();
    }

    @Override
    public void saveWriter(Writer writer) {
        this.writerRepository.save(writer);
    }

    @Override
    public Writer findWriter(int id) throws WriterNotFoundException {
        Optional<Writer> writer = writerRepository.findById(id);
        if(writer.isPresent()){
            return writer.get();
        } else {
            throw new WriterNotFoundException("There is no writer with that id");
        }
    }

    @Override
    public void deleteWriter(int id) throws WriterNotFoundException {
        Long count = writerRepository.countByWriterId(id);
        if(count == null || count == 0){
            throw new WriterNotFoundException("No Writer with such id");
        } else{
            writerRepository.deleteById(id);
        }
    }
}
