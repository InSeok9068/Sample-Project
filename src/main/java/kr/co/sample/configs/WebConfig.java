package kr.co.sample.configs;

import kr.co.sample.interceptors.TempInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final int DEFAULT_CONNECTION_TIME_OUT = 2;
    public static final int DEFAULT_READ_TIME_OUT = 10;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TempInterceptor());
    }

}
