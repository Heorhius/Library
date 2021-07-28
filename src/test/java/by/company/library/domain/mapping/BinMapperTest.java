package by.company.library.domain.mapping;

import by.company.library.IntegrationTestBase;
import by.company.library.domain.dbo.BinEntity;
import by.company.library.domain.dto.BinDto;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class BinMapperTest extends IntegrationTestBase {

    public static final BinMapper mapper = new BinMapper(new ModelMapper());

    private BinDto binDto;
    private BinEntity binEntity;

    @Test
    void testFromListDbo() {
        binEntity = new BinEntity();
        binEntity.setId(4);
        binEntity.setFloor(2);
        binEntity.setRoom(1);
        binEntity.setBinNo(4509);

        List<BinDto> fromList = mapper.fromListDbo(List.of(binEntity));
        binDto = fromList.get(0);

        boolean isEqual = (Objects.equals(binDto.getId(), binEntity.getId()) &&
                Objects.equals(binDto.getFloor(), binEntity.getFloor()) &&
                Objects.equals(binDto.getRoom(), binEntity.getRoom()) &&
                Objects.equals(binDto.getBinNo(), binEntity.getBinNo()));
        assertTrue(isEqual);
    }

    @Test
    void testFromDbo() {
        binEntity = new BinEntity();
        binEntity.setId(4);
        binEntity.setFloor(2);
        binEntity.setRoom(1);
        binEntity.setBinNo(4509);

        binDto = mapper.fromDbo(binEntity);

        boolean isEqual = (Objects.equals(binDto.getId(), binEntity.getId()) &&
                Objects.equals(binDto.getFloor(), binEntity.getFloor()) &&
                Objects.equals(binDto.getRoom(), binEntity.getRoom()) &&
                Objects.equals(binDto.getBinNo(), binEntity.getBinNo()));
        assertTrue(isEqual);
    }

    @Test
    void testToDbo() {
        binDto = new BinDto();
        binDto.setId(4);
        binDto.setFloor(2);
        binDto.setRoom(1);
        binDto.setBinNo(4509);

        binEntity = mapper.toDbo(binDto);

        boolean isEqual = (Objects.equals(binDto.getId(), binEntity.getId()) &&
                Objects.equals(binDto.getFloor(), binEntity.getFloor()) &&
                Objects.equals(binDto.getRoom(), binEntity.getRoom()) &&
                Objects.equals(binDto.getBinNo(), binEntity.getBinNo()));
        assertTrue(isEqual);
    }
}