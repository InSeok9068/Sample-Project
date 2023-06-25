package kr.co.sample.service;

import kr.co.sample.dtos.TempDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.entitys.TempEntity;
import kr.co.sample.repositories.TempRepository;
import kr.co.sample.services.TempService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class TempServiceTest2 {
    @Mock
    private TempRepository tempRepository;

    @InjectMocks
    private TempService tempService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTempList() {
        List<TempEntity> tempEntityList = new ArrayList<>();
        tempEntityList.add(TempEntity.builder().id(1L).build());

        when(tempRepository.findAll()).thenReturn(tempEntityList);

        ResultGenericDto<List<TempDto>> result = tempService.getTempList();

        assertTrue(result.checkSuccess());
        assertEquals(1, result.getData().size());
        assertEquals(1, result.getData().get(0).getId());
    }

    @Test
    void tesGetTemp() {
        TempEntity tempEntity = TempEntity.builder().id(1L).build();

        when(tempRepository.findById(1L)).thenReturn(Optional.of(tempEntity));

        ResultGenericDto<TempDto> result = tempService.getTemp(1L);

        assertTrue(result.checkSuccess());
        assertEquals(1, result.getData().getId());
    }
}
