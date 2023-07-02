package kr.co.sample.dtos;

import kr.co.sample.dtos.common.EventDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class EventDataDto {

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class Event extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventAsync extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventTransaction extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventTransactionCase1 extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventTransactionCase2 extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventTransactionCase3 extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventTransactionCase4 extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventTransactionCase5 extends EventDto {
        private final String data;
    }

    @Getter
    @Builder
    @ToString(callSuper = true)
    public static class EventTransactionCase6 extends EventDto {
        private final String data;
    }
}
