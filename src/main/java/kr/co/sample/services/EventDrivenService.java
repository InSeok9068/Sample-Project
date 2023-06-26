package kr.co.sample.services;

import kr.co.sample.repositories.TempRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventDrivenService {

    private final TempRepository tempRepository;

    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent() {
        log.info("publishEvent");
        eventPublisher.publishEvent(new Event("Event Class"));
    }

    public void publishEventAsync() {
        log.info("publishEventAsync");
        eventPublisher.publishEvent(new EventAsync("Event Async Class"));
    }

    @Transactional
    public void publishEventTransaction() {
        log.info("publishEventTransaction");
        eventPublisher.publishEvent(new EventTransaction("Event Transaction Class"));
    }

    @EventListener
    public void subscribeEvent(Event event) {
        log.info("subscribeEvent : {}", event.data());
    }

    @Async
    @EventListener
    public void subscribeEventAsync(EventAsync event) {
        log.info("subscribeEventAsync : {}", event.data());
    }

    @TransactionalEventListener
    public void subscribeEventTransaction(EventTransaction event) {
        log.info("subscribeEventTransaction : {}", event.data());
    }

    record Event(String data) {
    }

    record EventAsync(String data) {
    }

    record EventTransaction(String data) {
    }
}
