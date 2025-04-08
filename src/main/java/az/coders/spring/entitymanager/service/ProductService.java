package az.coders.spring.entitymanager.service;

import az.coders.spring.entitymanager.entity.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    List<Product> getProductsByName(String name);
}
