package by.company.library.repository;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.FineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FineRepositoryTest extends IntegrationTestBase {

    public static final Integer AMOUNT20_ID = 1;

    @Autowired
    private FineRepository fineRepository;

    @Test
    void testFindById(){
        Optional<FineEntity> fine = fineRepository.findById(AMOUNT20_ID);
        assertTrue(fine.isPresent());
    }

    @Test
    void testSave(){
        FineEntity fine = FineEntity.builder()
                .amount(BigDecimal.valueOf(10))
                .paid(true)
                .build();
        fineRepository.save(fine);
        assertNotNull(fine.getId());
    }

}