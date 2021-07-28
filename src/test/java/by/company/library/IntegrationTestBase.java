package by.company.library;

import by.company.library.initializer.MySQL;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(initializers = {
        MySQL.Initializer.class
})
@Transactional
public abstract class IntegrationTestBase {
    @BeforeAll
    static void init(){
        MySQL.container.start();
    }
}
