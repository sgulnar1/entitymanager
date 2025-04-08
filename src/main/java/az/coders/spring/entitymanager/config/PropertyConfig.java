package az.coders.spring.entitymanager.config;

import az.coders.spring.entitymanager.entity.Product;
import az.coders.spring.entitymanager.model.ProductProperty;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties
class PropertyConfig {
    private ProductProperty product;
    private List<Integer> branches;
    @PostConstruct
    void init() {
        System.out.println("product = " + product);
        System.out.println("branches = " + branches);
    }
}