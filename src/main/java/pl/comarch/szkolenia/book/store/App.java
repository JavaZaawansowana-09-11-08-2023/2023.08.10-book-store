package pl.comarch.szkolenia.book.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.comarch.szkolenia.book.store.interceptors.Interceptor;

import java.sql.Connection;

@SpringBootApplication
public class App implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor());
    }

    @Bean
    public Interceptor interceptor() {
        return new Interceptor();
    }
}
