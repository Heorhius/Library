package by.company.library.repository;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.BookEntity;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class BookRepositoryTest extends IntegrationTestBase {

    public static final String ISBN = "978-045120863";

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testFindById(){
        Optional<BookEntity> book = bookRepository.findById(ISBN);
        assertTrue(book.isPresent());
    }

    @Test
    void testFindByFirstName(){
        Optional<BookEntity> book = bookRepository.findByNameContaining("fer");
        assertTrue(book.isPresent());
    }

    @Test
    void testFindByNameAndPrice(){
        List<BookEntity> book = bookRepository.findAllByNameAndPrice("The Divine Comedy", BigDecimal.valueOf(14));
        assertThat(book, hasSize(1));
    }
}