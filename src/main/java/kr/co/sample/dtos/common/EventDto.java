package kr.co.sample.dtos.common;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@ToString
@SuperBuilder
public abstract class EventDto {
    @Builder.Default
    private final LocalDateTime timestamp = LocalDateTime.now();
}
