package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {
    @Bean(name = "product1")
    @Scope("prototype")
    public Product product1(){
        return new Product("Iphone 13", 1300, "This is the latest phone");
    }

    @Bean(name = "product2")
    @Scope("singleton")
    public Product product2(){
        return  new Product("Samsung galaxy", 1000, "This is the best samsung phone");
    }
}
