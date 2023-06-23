package kr.co.sample.frameworks.lock;

import java.util.concurrent.locks.Lock;

public class AutoCloseableLock implements AutoCloseable {

    private final Lock lock;

    private AutoCloseableLock(Lock lock) {
        this.lock = lock;
    }

    public static AutoCloseableLock of(Lock lock) {
        return new AutoCloseableLock(lock);
    }

    @Override
    public void close() {
        this.lock.unlock();
    }
}
