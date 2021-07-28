package by.company.library.repository;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryTest extends IntegrationTestBase {

    public static final Integer DAN_ID = 1;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testFindById(){
        Optional<AuthorEntity> author = authorRepository.findById(DAN_ID);
        assertTrue(author.isPresent());
    }

    @Test
    void testFindByName(){
        List<AuthorEntity> author = authorRepository.findAllByNameAndSurname("Dan", "Brown");
        assertThat(author, hasSize(1));
    }

}