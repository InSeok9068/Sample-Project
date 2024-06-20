package kr.co.sample.services;

import kr.co.sample.dtos.common.ResultDto;
import kr.co.sample.dtos.common.ResultGenericDto;
import kr.co.sample.entitys.TempEntity;
import kr.co.sample.repositories.TempRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class CacheService {
    private static final Map<String, String> CACHE_DATA_MAP = new ConcurrentHashMap<>();
    private static final String CACHE_NAME = "cache";

    private final CacheManager cacheManager;
    private final TempRepository tempRepository;

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

    @Transactional
    public ResultDto transactionDbAndRedis(Long id) {
        tempRepository.save(TempEntity.builder()
                .id(id)
                .build());
        Cache cache = Objects.requireNonNull(cacheManager.getCache(CACHE_NAME));
        cache.put(id, id);
        throw new RuntimeException("DB 성공 및 Redis 성공 후 트랜잭션 동작");
    }
}
