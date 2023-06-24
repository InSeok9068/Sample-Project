package kr.co.sample.services;

import kr.co.sample.dtos.common.ResultGenericResponseDto;
import kr.co.sample.dtos.common.ResultResponseDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CachingService {

    private static final Map<String, String> CACHE_DATA_MAP = new ConcurrentHashMap<>();

    @Cacheable(value = "cache", key = "#key")
    public ResultGenericResponseDto<String> getData(String key) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResultGenericResponseDto.ofSuccess(CACHE_DATA_MAP.get(key));
    }

    public ResultResponseDto addData(String key, String data) {
        CACHE_DATA_MAP.put(key, data);
        return ResultResponseDto.ofSuccess();
    }

    @CacheEvict(value = "cache", key = "#key")
    public ResultResponseDto removeData(String key) {
        CACHE_DATA_MAP.remove(key);
        return ResultResponseDto.ofSuccess();
    }
}
