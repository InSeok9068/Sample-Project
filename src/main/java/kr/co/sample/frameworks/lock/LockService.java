package kr.co.sample.frameworks.lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

@Slf4j
@Service
@RequiredArgsConstructor
public class LockService {

    private final RedisLockRegistry redisLockRegistry;

    public AutoCloseableLock tryLockWithDefaultWait(String lockKey) {
        return tryLock(lockKey, 30L, TimeUnit.SECONDS);
    }

    public AutoCloseableLock tryLock(String lockKey, long waitTime, TimeUnit timeUnit) {
        Lock lock = redisLockRegistry.obtain(lockKey);
        boolean locked;

        try {
            locked = lock.tryLock(waitTime, timeUnit);
        } catch (InterruptedException e) {
            log.error("Lcok 생성 실패 : {}", ExceptionUtils.getStackTrace(e));
            throw new RuntimeException(e);
        }

        if (!locked) {
            return null;
        }

        return AutoCloseableLock.of(lock);
    }

    public String makeLockKey(String... keys) {
        List<String> keyList = new ArrayList<>(Arrays.asList(keys));
        if (CollectionUtils.isEmpty(keyList)) {
            throw new RuntimeException("keyList is empty");
        } else {
            return String.join("-", keyList);
        }
    }
}
