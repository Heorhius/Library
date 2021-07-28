package by.company.library.repository;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.RoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RoleRepositoryTest extends IntegrationTestBase {

    public static final Integer ADMIN_ID = 1;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void testGetById(){
        Optional<RoleEntity> role = roleRepository.findById(ADMIN_ID);
        assertTrue(role.isPresent());
        role.ifPresent(entity ->{
            assertEquals("admin", entity.getRoleType());
        });
    }

    @Test
    void testSave(){
        RoleEntity role = RoleEntity.builder()
                .roleType("gnida")
                .build();
        roleRepository.save(role);
        assertNotNull(role.getId());
    }

}