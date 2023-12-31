package kr.co.sample.services;

import kr.co.sample.dtos.EventDataDto;
import kr.co.sample.entitys.TempEntity;
import kr.co.sample.repositories.TempRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventDrivenPubService {

    private final TempRepository tempRepository;

    private final ApplicationEventPublisher eventPublisher;

    public void publishEvent() {
        log.info("publishEvent");
        eventPublisher.publishEvent(EventDataDto.Event.builder()
                .data("Event Class")
                .build());
    }

    public void publishEventAsync() {
        log.info("publishEventAsync");
        eventPublisher.publishEvent(EventDataDto.EventAsync.builder()
                .data("Event Async Class")
                .build());
    }

    @Transactional
    public void publishEventTransaction() {
        log.info("publishEventTransaction");
        eventPublisher.publishEvent(EventDataDto.EventTransaction.builder()
                .data("Event Transaction Class")
                .build());
    }

    @Transactional
    public void publishEventTransactionCase1() {
        // 발행 주체에서 에러가 발생했기 때문에 이벤트는 해당 커밋이 완료된 시점에서 실행되기때문에 실행 안됨
        log.info("publishEventTransactionCase1");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(EventDataDto.EventTransactionCase1.builder()
                .data("Event Transaction Case1 Class")
                .build());
        throw new RuntimeException("에러 발생");
    }

    @Transactional
    public void publishEventTransactionCase2() {
        // 발행 주체에서는 정상적인 트랜잭션이 완료되고 구독 주체에서 에러가 발생
        // ※ 구독 주체에서 발생한 에러는 발행주체의 트랜잰셕을 영향을 주지 못함
        log.info("publishEventTransactionCase2");
        eventPublisher.publishEvent(EventDataDto.EventTransactionCase2.builder()
                .data("Event Transaction Case2 Class")
                .build());
        tempRepository.save(TempEntity.builder().build());
    }

    @Transactional
    public void publishEventTransactionCase3() {
        // 발행 주체에서 정상적인 트랜잭션이 완료되고 구독 주체에서도 정상적인 트랜잭션이 완료
        // ※ @Transactional(propagation = Propagation.REQUIRES_NEW) 필수적으로 입력해주지 않아서 커밋 X
        log.info("publishEventTransactionCase3");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(EventDataDto.EventTransactionCase3.builder()
                .data("Event Transaction Case3 Class")
                .build());
    }

    @Transactional
    public void publishEventTransactionCase4() {
        // 발행 주체에서 정상적인 트랜잭션이 완료되고 구독 주체에서도 정상적인 트랜잭션이 완료
        // ※ @Transactional(propagation = Propagation.REQUIRES_NEW) 필수적으로 입력해주어서 커밋 O
        log.info("publishEventTransactionCase4");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(EventDataDto.EventTransactionCase4.builder()
                .data("Event Transaction Case4 Class")
                .build());
    }

    @Transactional
    public void publishEventTransactionCase5() {
        // 발행 주체에서 정상적인 트랜잭션이 완료되고 구독 주체에서도 정상적인 트랜잭션이 완료
        // ※ @Async 비동기로 이벤트가 구독하여 트랜잭션이 분리되어 실행됨
        log.info("publishEventTransactionCase5");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(EventDataDto.EventTransactionCase5.builder()
                .data("Event Transaction Case5 Class")
                .build());
    }

    @Transactional
    public void publishEventTransactionCase6() {
        // 발행 주체에서는 정상적인 트랜잭션이 완료되고 구독 주체에서 에러가 발생
        // ※ @Async 비동기로 이벤트가 구독하여 트랜잭션이 분리되어 실행됨
        // ※ @Transactional(propagation = Propagation.REQUIRES_NEW) 비동기로 실행된 메서드도
        //    자기만의 트랜잭션을 가짐으로써 구독 주체에서 에러가 발생하면 구독 주체에서 삽입한 데이터는 롤백
        log.info("publishEventTransactionCase6");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(EventDataDto.EventTransactionCase5.builder()
                .data("Event Transaction Case5 Class")
                .build());
    }
}
