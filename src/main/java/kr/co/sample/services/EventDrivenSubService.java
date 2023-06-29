package kr.co.sample.services;

import kr.co.sample.dtos.EventDataDto;
import kr.co.sample.entitys.TempEntity;
import kr.co.sample.repositories.TempRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventDrivenSubService {

    private final TempRepository tempRepository;

    @EventListener
    public void subscribeEvent(EventDataDto.Event event) {
        log.info("subscribeEvent : {}", event);
    }

    @Async
    @EventListener
    public void subscribeEventAsync(EventDataDto.EventAsync event) {
        log.info("subscribeEventAsync : {}", event);
    }

    @TransactionalEventListener
    public void subscribeEventTransaction(EventDataDto.EventTransaction event) {
        log.info("subscribeEventTransaction : {}", event);
    }

    @TransactionalEventListener
    public void subscribeEventTransactionCase1(EventDataDto.EventTransactionCase1 event) {
        log.info("subscribeEventTransactionCase1 : {}", event);
    }

    @TransactionalEventListener
    public void subscribeEventTransactionCase2(EventDataDto.EventTransactionCase2 event) {
        log.info("subscribeEventTransactionCase2 : {}", event);
        throw new RuntimeException("에러 발생");
    }

    @TransactionalEventListener
    public void subscribeEventTransactionCase3(EventDataDto.EventTransactionCase3 event) {
        log.info("subscribeEventTransactionCase3 : {}", event);
        tempRepository.save(TempEntity.builder().build());
    }

    @TransactionalEventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void subscribeEventTransactionCase4(EventDataDto.EventTransactionCase4 event) {
        log.info("subscribeEventTransactionCase4 : {}", event);
        tempRepository.save(TempEntity.builder().build());
    }

    @Async
    @TransactionalEventListener
    public void subscribeEventTransactionCase5(EventDataDto.EventTransactionCase5 event) {
        log.info("subscribeEventTransactionCase5 : {}", event);
        tempRepository.save(TempEntity.builder().build());
    }

    @Async
    @TransactionalEventListener
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void subscribeEventTransactionCase6(EventDataDto.EventTransactionCase6 event) {
        log.info("subscribeEventTransactionCase6 : {}", event);
        tempRepository.save(TempEntity.builder().build());
    }
}
