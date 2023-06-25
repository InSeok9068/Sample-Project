package kr.co.sample.services;

import kr.co.sample.dtos.TempDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.repositories.TempRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TempService {

    private final TempRepository tempRepository;

    public ResultGenericDto<List<TempDto>> getTempList() {
        return ResultGenericDto.ofSuccess(tempRepository.findAll()
                .stream()
                .map(tempEntity -> TempDto.builder().id(tempEntity.getId()).build())
                .collect(Collectors.toList()));
    }

    public ResultGenericDto<TempDto> getTemp(Long id) {
        return ResultGenericDto.ofSuccess(tempRepository.findById(id)
                .map(tempEntity -> TempDto.builder().id(tempEntity.getId()).build())
                .orElseThrow());
    }
}
