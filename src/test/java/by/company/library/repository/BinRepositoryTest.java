package by.company.library.repository;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.BinEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinRepositoryTest extends IntegrationTestBase {

    public static final Integer FLOOR_No4_ID = 1;

    @Autowired
    private BinRepository binRepository;

    @Test
    void testFindById(){
        Optional<BinEntity> bin = binRepository.findById(FLOOR_No4_ID);
        assertTrue(bin.isPresent());
    }

    @Test
    void testSave(){
        BinEntity bin = BinEntity.builder()
                .floor(2)
                .room(1)
                .binNo(2354)
                .build();
        binRepository.save(bin);
        assertNotNull(bin.getId());
    }

}