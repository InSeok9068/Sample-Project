package kr.co.sample.mapper;

import kr.co.sample.dtos.TempDto;
import kr.co.sample.entitys.TempEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TempMapper {
    TempMapper INSTANCE = Mappers.getMapper(TempMapper.class);

    TempDto toTempDto(TempEntity tempEntity);

    TempEntity toTempEntity(TempDto tempDto);
}
