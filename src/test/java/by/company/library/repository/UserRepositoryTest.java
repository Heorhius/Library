package by.company.library.repository;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.UserEntity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;


class UserRepositoryTest extends IntegrationTestBase {

    public static final String IVAN_PASSPORT_No = "MP2316484";

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindById(){
        Optional<UserEntity> user = userRepository.findById(IVAN_PASSPORT_No);
        assertTrue(user.isPresent());
    }

    @Test
    void testFindByName(){
        Optional<UserEntity> user = userRepository.findByNameContaining("va");
        assertTrue(user.isPresent());
    }

    @Test
    void testFindAllByNameAndSurname(){
        List<UserEntity> user = userRepository.findAllByNameAndSurname("Ivan", "Ivanov");
        assertThat(user, hasSize(1));
    }

}