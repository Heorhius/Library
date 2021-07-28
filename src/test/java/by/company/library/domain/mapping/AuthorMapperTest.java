package by.company.library.domain.mapping;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.AuthorEntity;
import by.company.library.domain.dto.AuthorDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorMapperTest extends IntegrationTestBase {

    public static final AuthorMapper mapper = new AuthorMapper(new ModelMapper());

    private AuthorDto authorDto;
    private AuthorEntity authorEntity;

    @Test
    void testFromListDbo() {
        authorEntity = new AuthorEntity();
        authorEntity.setId(4);
        authorEntity.setName("Donalt");
        authorEntity.setSurname("Duck");
        authorEntity.setPlaceOfBirth("Yorker");
        authorEntity.setBirthDate(new Date());

        List<AuthorDto> fromList = mapper.fromListDbo(List.of(authorEntity));
        authorDto = fromList.get(0);

        boolean isEqual = (authorDto.getId() == authorEntity.getId() &&
                authorDto.getName().equals(authorEntity.getName()) &&
                authorDto.getSurname().equals(authorEntity.getSurname()) &&
                authorDto.getPlaceOfBirth().equals(authorEntity.getPlaceOfBirth()) &&
                authorDto.getBirthDate().equals(authorEntity.getBirthDate()));

        assertTrue(isEqual);

    }

    @Test
    void testFromDbo() {
        authorEntity = new AuthorEntity();
        authorEntity.setId(4);
        authorEntity.setName("Donalt");
        authorEntity.setSurname("Duck");
        authorEntity.setPlaceOfBirth("Yorker");
        authorEntity.setBirthDate(new Date());

        authorDto = mapper.fromDbo(authorEntity);

        boolean isEqual = (authorDto.getId() == authorEntity.getId() &&
                authorDto.getName().equals(authorEntity.getName()) &&
                authorDto.getSurname().equals(authorEntity.getSurname()) &&
                authorDto.getPlaceOfBirth().equals(authorEntity.getPlaceOfBirth()) &&
                authorDto.getBirthDate().equals(authorEntity.getBirthDate()));

        assertTrue(isEqual);

    }

    @Test
    void testToDbo() {
        authorDto = new AuthorDto();
        authorDto.setId(4);
        authorDto.setName("Donalt");
        authorDto.setSurname("Duck");
        authorDto.setPlaceOfBirth("Yorker");
        authorDto.setBirthDate(new Date());

        authorEntity = mapper.toDbo(authorDto);

        boolean isEqual = (authorDto.getId() == authorEntity.getId() &&
                authorDto.getName().equals(authorEntity.getName()) &&
                authorDto.getSurname().equals(authorEntity.getSurname()) &&
                authorDto.getPlaceOfBirth().equals(authorEntity.getPlaceOfBirth()) &&
                authorDto.getBirthDate().equals(authorEntity.getBirthDate()));

        assertTrue(isEqual);
    }
}