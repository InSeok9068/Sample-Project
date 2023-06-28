package kr.co.sample.dtos.common;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@ToString
@SuperBuilder
public class EventDto {
    private final LocalDateTime timestamp;

    public EventDto() {
        this.timestamp = LocalDateTime.now();
    }
}
