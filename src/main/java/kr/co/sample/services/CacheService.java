package kr.co.sample.services;

import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CacheService {
    private static final Map<String, String> CACHE_DATA_MAP = new ConcurrentHashMap<>();
    private static final String CACHE_NAME = "cache";

    private final CacheManager cacheManager;

    @Cacheable(value = CACHE_NAME, key = "#key")
    public ResultGenericDto<String> getData(String key) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResultGenericDto.ofSuccess(CACHE_DATA_MAP.get(key));
    }

    public ResultDto addData(String key, String data) {
        CACHE_DATA_MAP.put(key, data);
        return ResultDto.ofSuccess();
    }

    @CacheEvict(value = CACHE_NAME, key = "#key")
    public ResultDto removeData(String key) {
        CACHE_DATA_MAP.remove(key);
        return ResultDto.ofSuccess();
    }

    private void removeCache() {
        Cache cache = cacheManager.getCache(CACHE_NAME);
        if (Objects.nonNull(cache)) {
            cache.clear();
        }
    }
}
