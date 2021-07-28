package by.company.library.domain.mapping;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.RoleEntity;
import by.company.library.domain.dto.RoleDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class RoleMapperTest extends IntegrationTestBase {

    public static final RoleMapper mapper = new RoleMapper(new ModelMapper());

    private RoleDto roleDto;
    private RoleEntity roleEntity;

    @Test
    void testFromListDbo(){
        roleEntity = new RoleEntity();
        roleEntity.setId(4);
        roleEntity.setRoleType("god");

        List<RoleDto> fromList = mapper.fromListDbo(List.of(roleEntity));
        roleDto = fromList.get(0);

        boolean isEqual = (Objects.equals(roleDto.getId(), roleEntity.getId()) &&
                Objects.equals(roleDto.getRoleType(), roleEntity.getRoleType()));

        assertTrue(isEqual);
    }

    @Test
    void testFromDbo(){
        roleEntity = new RoleEntity();
        roleEntity.setId(4);
        roleEntity.setRoleType("god");

        roleDto = mapper.fromDbo(roleEntity);

        boolean isEqual = (Objects.equals(roleDto.getId(), roleEntity.getId()) &&
                Objects.equals(roleDto.getRoleType(), roleEntity.getRoleType()));

        assertTrue(isEqual);
    }

    @Test
    void testToDbo(){
        roleDto = new RoleDto();
        roleDto.setId(4);
        roleDto.setRoleType("god");

        roleEntity = mapper.toDbo(roleDto);

        boolean isEqual = (Objects.equals(roleDto.getId(), roleEntity.getId()) &&
                Objects.equals(roleDto.getRoleType(), roleEntity.getRoleType()));

        assertTrue(isEqual);
    }
}