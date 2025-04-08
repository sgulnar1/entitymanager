package az.coders.spring.entitymanager;

import az.coders.spring.entitymanager.entity.Category;
import az.coders.spring.entitymanager.entity.Product;
import az.coders.spring.entitymanager.entity.ProductDetail;
import az.coders.spring.entitymanager.repository.ProductDetailRepository;
import az.coders.spring.entitymanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootApplication
public class EntitymanagerApplication implements CommandLineRunner {
//    @Value("${product.categories[0].id}")
//    List<Category> categories;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;

    public static void main(String[] args) {
        SpringApplication.run(EntitymanagerApplication.class, args);
    }

    @Override
    //@Transactional
    public void run(String... args) throws Exception {
     //   System.out.println("categories: " + categories);
        ProductDetail productDetail = new ProductDetail("desc 3");
        Category category = new Category(4);
        Product product = new Product("test new 3", productDetail, category);
        //productDetailRepository.save(productDetail);
        productRepository.save(product);
    }
}