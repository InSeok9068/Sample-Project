package kr.co.sample.service;

import kr.co.sample.dtos.TempDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.repositories.TempRepository;
import kr.co.sample.services.TempService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class TempServiceTest1 {

    @Autowired
    private TempRepository tempRepository;

    private TempService tempService;

    @BeforeEach
    void setUp() {
        tempService = new TempService(tempRepository);
    }

    @Test
    void testGetTempList() {
        ResultGenericDto<List<TempDto>> result = tempService.getTempList();

        assertTrue(result.checkSuccess());
        assertEquals(1, result.getData().size());
        assertEquals(1, result.getData().get(0).getId());
    }

    @Test
    void tesGetTemp() {
        ResultGenericDto<TempDto> result = tempService.getTemp(1L);

        assertTrue(result.checkSuccess());
        assertEquals(1, result.getData().getId());
    }
}
