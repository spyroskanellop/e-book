package com.example.EBook.repository;

import com.example.EBook.model.Writer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class WriterRepositoryTest {

    @Autowired
    WriterRepository writerRepository;

    @Test
    public void testNew(){
        Writer writer = new Writer();
        writer.setFirstName("Spyros");
        writer.setLastName("Kan");
//        writer.setBookCollection(null);

        Writer savedWriter = writerRepository.save(writer);
        Assertions.assertThat(savedWriter).isNotNull();
        Assertions.assertThat(savedWriter.getWriterId()).isGreaterThan(0);

    }
}
