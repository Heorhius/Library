package by.company.library.domain.mapping;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.FineEntity;
import by.company.library.domain.dto.FineDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FineMapperTest extends IntegrationTestBase {


    public static final FineMapper mapper = new FineMapper(new ModelMapper());

    private FineDto fineDto;
    private FineEntity fineEntity;

    @Test
    void testFromListDbo() {
        fineEntity = new FineEntity();
        fineEntity.setId(3);
        fineEntity.setAmount(BigDecimal.valueOf(10));
        fineEntity.setPaid(true);

        List<FineDto> fromList = mapper.fromListDbo(List.of(fineEntity));
        fineDto = fromList.get(0);

        boolean isEqual = (fineDto.getId() == fineEntity.getId() &&
                fineDto.getAmount().equals(fineEntity.getAmount()) &&
                fineDto.isPaid() == fineEntity.isPaid());

        assertTrue(isEqual);
    }

    @Test
    void testFromDbo() {
        fineEntity = new FineEntity();
        fineEntity.setId(3);
        fineEntity.setAmount(BigDecimal.valueOf(10));
        fineEntity.setPaid(true);

        fineDto = mapper.fromDbo(fineEntity);

        boolean isEqual = (fineDto.getId() == fineEntity.getId() &&
                fineDto.getAmount().equals(fineEntity.getAmount()) &&
                fineDto.isPaid() == fineEntity.isPaid());

        assertTrue(isEqual);
    }

    @Test
    void testToDbo() {
        fineDto = new FineDto();
        fineDto.setId(3);
        fineDto.setAmount(BigDecimal.valueOf(10));
        fineDto.setPaid(true);

        fineEntity = mapper.toDbo(fineDto);

        boolean isEqual = (fineDto.getId() == fineEntity.getId() &&
                fineDto.getAmount().equals(fineEntity.getAmount()) &&
                fineDto.isPaid() == fineEntity.isPaid());

        assertTrue(isEqual);
    }
}