package kr.co.sample.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.util.Objects;

public class JacksonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JacksonUtil.class);

    private static final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();

    private JacksonUtil() {

    }

    public static String writeValueAsStringThrowIfFailed(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("JSON 직렬화 실패");
        }
    }

    public static String writeValueAsStringNullIfFailed(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.warn("JSON 직렬화 실패 : {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    public static <T> T deserializeJsonNulIfFailed(String content, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(content, typeReference);
        } catch (JsonProcessingException e) {
            logger.warn("JSON 역직렬화 실패 : {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    public static <T> T deserializeJsonNulIfFailed(String content, Class<T> clazz) {
        try {
            return objectMapper.readValue(content, clazz);
        } catch (JsonProcessingException e) {
            logger.warn("JSON 역직렬화 실패 : {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }

    public static <T> T convertJsonObjectTypeNullIfFailed(Object obj, TypeReference<T> typeReference) {
        String json = writeValueAsStringNullIfFailed(obj);
        if (Objects.isNull(json)) {
            return null;
        }
        return deserializeJsonNulIfFailed(json, typeReference);
    }
}
