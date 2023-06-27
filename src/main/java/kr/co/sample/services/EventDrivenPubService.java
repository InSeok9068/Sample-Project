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
        eventPublisher.publishEvent(new EventDataDto.Event("Event Class"));
    }

    public void publishEventAsync() {
        log.info("publishEventAsync");
        eventPublisher.publishEvent(new EventDataDto.EventAsync("Event Async Class"));
    }

    @Transactional
    public void publishEventTransaction() {
        log.info("publishEventTransaction");
        eventPublisher.publishEvent(new EventDataDto.EventTransaction("Event Transaction Class"));
    }

    @Transactional
    public void publishEventTransactionCase1() {
        // 발행 주체에서 에러가 발생했기 때문에 이벤트는 해당 커밋이 완료된 시점에서 실행되기때문에 실행 안됨
        log.info("publishEventTransactionCase1");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(new EventDataDto.EventTransactionCase1("Event Transaction Case1 Class"));
        throw new RuntimeException("에러 발생");
    }

    @Transactional
    public void publishEventTransactionCase2() {
        // 발행 주체에서는 정상적인 트랜잭션이 완료되고 구독 주체에서 에러가 발생
        // ※ 구독 주체에서 발생한 에러는 발행주체의 트랜잰셕을 영향을 주지 못함
        log.info("publishEventTransactionCase2");
        eventPublisher.publishEvent(new EventDataDto.EventTransactionCase2("Event Transaction Case2 Class"));
        tempRepository.save(TempEntity.builder().build());
    }

    @Transactional
    public void publishEventTransactionCase3() {
        // 발행 주체에서 정상적인 트랜잭션이 완료되고 구독 주체에서도 정상적인 트랜잭션이 완료
        // ※ @Transactional(propagation = Propagation.REQUIRES_NEW) 필수적으로 입력해주지 않아서 커밋 X
        log.info("publishEventTransactionCase3");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(new EventDataDto.EventTransactionCase3("Event Transaction Case3 Class"));
    }

    @Transactional
    public void publishEventTransactionCase4() {
        // 발행 주체에서 정상적인 트랜잭션이 완료되고 구독 주체에서도 정상적인 트랜잭션이 완료
        // ※ @Transactional(propagation = Propagation.REQUIRES_NEW) 필수적으로 입력해주어서 커밋 O
        log.info("publishEventTransactionCase4");
        tempRepository.save(TempEntity.builder().build());
        eventPublisher.publishEvent(new EventDataDto.EventTransactionCase4("Event Transaction Case4 Class"));
    }
}
