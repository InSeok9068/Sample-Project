package kr.co.sample.dtos.common;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public abstract class EventDto {
    private final LocalDateTime timestamp;

    public EventDto() {
        timestamp = LocalDateTime.now();
    }
}
