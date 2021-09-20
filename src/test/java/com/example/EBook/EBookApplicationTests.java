package com.example.EBook;

import com.example.EBook.model.Writer;
import com.example.EBook.repository.WriterRepository;
import com.example.EBook.service.WriterNotFoundException;
import com.example.EBook.service.WriterService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EBookApplicationTests {

    @Autowired
    private WriterService writerService;

    @MockBean
    private WriterRepository writerRepository;

    @Test
    public void getWritersTest(){
        when(writerRepository.findAll()).thenReturn((Stream.of(
                new Writer(1, "s", "k", null),
                new Writer(2, "sa", "k", null)
                )).collect(Collectors.toList()));
        assertEquals(2, writerService.getAllWriters().size());
    }
    @Test
    public void addWriterTest(){
        Writer writer = new Writer(1, "s", "k", null);
        when(writerRepository.save(writer)).thenReturn(null);
        writerService.saveWriter(writer);
    }
//    @Test
//    @Rollback(false)
//    public void deleteWriterTest() throws WriterNotFoundException {
//        Writer writer = new Writer(1, "s", "k", null);
//
//        when(writerRepository.findById(writer.getWriterId())).thenReturn(java.util.Optional.of(writer));
//        writerService.deleteWriter(writer.getWriterId());
//        verify(writerRepository).deleteById(writer.getWriterId());
//    }
    @Test
    public void findWriterTest() throws WriterNotFoundException {
        Writer writer = new Writer(1, "s", "k", null);
        when(writerRepository.findById(1)).thenReturn(java.util.Optional.of(writer));
        assertEquals(writer, writerService.findWriter(1));
    }

    @Test
    public void updateWriterTest(){
        Writer writer = new Writer(1, "s", "k", null);
        Writer newWriter = new Writer(2,"a", "b", null);
        when(writerRepository.findById(writer.getWriterId())).thenReturn(java.util.Optional.of(writer));

        writer.setFirstName(newWriter.getFirstName());
        writer.setLastName(newWriter.getLastName());
        writer.setBookList(newWriter.getBookList());

        writerService.saveWriter(writer);
        verify(writerRepository, times(1)).save(newWriter);
        assertNotEquals(writer.getWriterId(), newWriter.getWriterId());

        assertEquals(writer.getFirstName(), newWriter.getFirstName());
        assertEquals(writer.getLastName(), newWriter.getLastName());
        assertEquals(writer.getBookList(), newWriter.getBookList());
    }
}
