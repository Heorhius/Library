package by.company.library.domain.mapping;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.BookEntity;
import by.company.library.domain.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest extends IntegrationTestBase {

    public static final BookMapper mapper = new BookMapper(new ModelMapper());

    private BookDto bookDto;
    private BookEntity bookEntity;

    @Test
    void testFromListDbo() {
        bookEntity = new BookEntity();
        bookEntity.setIsbn("978-045120000");
        bookEntity.setName("Ring");
        bookEntity.setPublishingDate(new Date());
        bookEntity.setPrice(BigDecimal.valueOf(10));
        bookEntity.setInStock(true);

        List<BookDto> fromList = mapper.fromListDbo(List.of(bookEntity));
        bookDto = fromList.get(0);

        boolean isEqual = (bookDto.getIsbn().equals(bookEntity.getIsbn()) &&
                bookDto.getName().equals(bookEntity.getName()) &&
                bookDto.getPublishingDate().equals(bookEntity.getPublishingDate()) &&
                bookDto.getPrice().equals(bookEntity.getPrice()) &&
                bookDto.isInStock() == bookEntity.isInStock());

        assertTrue(isEqual);
    }

    @Test
    void testFromDbo() {
        bookEntity = new BookEntity();
        bookEntity.setIsbn("978-045120000");
        bookEntity.setName("Ring");
        bookEntity.setPublishingDate(new Date());
        bookEntity.setPrice(BigDecimal.valueOf(10));
        bookEntity.setInStock(true);

        bookDto = mapper.fromDbo(bookEntity);

        boolean isEqual = (bookDto.getIsbn().equals(bookEntity.getIsbn()) &&
                bookDto.getName().equals(bookEntity.getName()) &&
                bookDto.getPublishingDate().equals(bookEntity.getPublishingDate()) &&
                bookDto.getPrice().equals(bookEntity.getPrice()) &&
                bookDto.isInStock() == bookEntity.isInStock());

        assertTrue(isEqual);
    }

    @Test
    void testToDbo() {
        bookDto = new BookDto();
        bookDto.setIsbn("978-045120000");
        bookDto.setName("Ring");
        bookDto.setPublishingDate(new Date());
        bookDto.setPrice(BigDecimal.valueOf(10));
        bookDto.setInStock(true);

        bookEntity = mapper.toDbo(bookDto);

        boolean isEqual = (bookDto.getIsbn().equals(bookEntity.getIsbn()) &&
                bookDto.getName().equals(bookEntity.getName()) &&
                bookDto.getPublishingDate().equals(bookEntity.getPublishingDate()) &&
                bookDto.getPrice().equals(bookEntity.getPrice()) &&
                bookDto.isInStock() == bookEntity.isInStock());

        assertTrue(isEqual);
    }
}