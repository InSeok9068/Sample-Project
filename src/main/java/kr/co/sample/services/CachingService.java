package kr.co.sample.services;

import kr.co.sample.dtos.common.ResultGenericResponseDto;
import kr.co.sample.dtos.common.ResultResponseDto;

public interface CachingService {
    ResultGenericResponseDto<String> getData(String key);

    ResultResponseDto addData(String key, String data);

    ResultResponseDto removeData(String key);
}
