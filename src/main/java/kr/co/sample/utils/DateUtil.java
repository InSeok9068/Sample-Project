package kr.co.sample.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private DateUtil() {
    }

    @Getter
    @RequiredArgsConstructor
    public enum DateFormatPattern {
        ISO_DATE("yyyy-MM-dd"),
        SLASH_DATE("yyyy/MM/dd"),
        DOT_DATE("yyyy.MM.dd");

        private final String pattern;
    }

    @Getter
    @RequiredArgsConstructor
    public enum DateTimeFormatPattern {
        ISO_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
        SLASH_DATE_TIME("yyyy/MM/dd HH:mm:ss"),
        DOT_DATE_TIME("yyyy.MM.dd HH:mm:ss");

        private final String pattern;
    }

    public static String format(LocalDate date, DateFormatPattern pattern) {
        return format(date, pattern.getPattern());
    }

    public static String format(LocalDateTime dateTime, DateTimeFormatPattern pattern) {
        return format(dateTime, pattern.getPattern());
    }

    public static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String format(LocalDateTime dateTime, String pattern) {
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseDate(String dateString, DateFormatPattern pattern) {
        return parseDate(dateString, pattern.getPattern());
    }

    public static LocalDate parseDate(String dateString, String pattern) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseDateTime(String dateTimeString, DateTimeFormatPattern pattern) {
        return parseDateTime(dateTimeString, pattern.getPattern());
    }

    public static LocalDateTime parseDateTime(String dateTimeString, String pattern) {
        return LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern(pattern));
    }
}
