package az.coders.spring.entitymanager.controller;

import az.coders.spring.entitymanager.entity.Product;
import az.coders.spring.entitymanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping
    public void addProduct(@Validated @RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping
    public List<Product> getProductsByName(@RequestParam(required = false) String name) {
        return productService.getProductsByName(name);
    }
}
