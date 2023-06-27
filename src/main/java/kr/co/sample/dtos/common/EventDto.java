package kr.co.sample.dtos.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@ToString
@SuperBuilder
@RequiredArgsConstructor
public class EventDto {
    private final LocalDateTime timestamp = LocalDateTime.now();
}
