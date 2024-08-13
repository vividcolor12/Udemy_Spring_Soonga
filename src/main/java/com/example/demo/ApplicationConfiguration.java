package com.example.demo;

import com.example.demo.product.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean //스프링아, 아래 메소드가 반환하는 객체를 스프링 빈으로 등록해줘
    public ProductRepository productRepository() {
        return new ProductRepository();
    }
}
