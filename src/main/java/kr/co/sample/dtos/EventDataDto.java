package kr.co.sample.dtos;

import kr.co.sample.dtos.common.EventDto;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

public class EventDataDto {

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class Event extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventAsync extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventTransaction extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventTransactionCase1 extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventTransactionCase2 extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventTransactionCase3 extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventTransactionCase4 extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventTransactionCase5 extends EventDto {
        private final String data;
    }

    @Getter
    @SuperBuilder
    @ToString(callSuper = true)
    public static class EventTransactionCase6 extends EventDto {
        private final String data;
    }
}
