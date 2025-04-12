package az.coders.spring.entitymanager;

import az.coders.spring.entitymanager.entity.*;
import az.coders.spring.entitymanager.repository.CategoryRepository;
import az.coders.spring.entitymanager.repository.ProductDetailRepository;
import az.coders.spring.entitymanager.repository.ProductRepository;
import az.coders.spring.entitymanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@SpringBootApplication
public class EntitymanagerApplication implements CommandLineRunner {
//    @Value("${product.categories[0].id}")
//    List<Category> categories;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(EntitymanagerApplication.class, args);
    }

    @Override
    //@Transactional
    public void run(String... args) throws Exception {
     //   System.out.println("categories: " + categories);
 //       ProductDetail productDetail = new ProductDetail("desc 3");
//        Category category = new Category(4);
//        Product product = new Product("test new 3", productDetail, category);
//        //productDetailRepository.save(productDetail);
//        productRepository.save(product);
//
//        Product product = new Product();
//        product.setProductName("name");
//        Category category = new Category();
//        category.setName("category 1");
//        categoryRepository.save(category);
//        product.setCategory(category);
//        product.setProductDetail(new ProductDetail("desc 1"));
//        productRepository.save(product);
//        //Product findProduct = productRepository.findById(100).get();
//        Order order = new Order();
//        Customer customer = new Customer();
//        customer.setName("Gulnar");
//        order.setCustomer(customer);
//        product.setOrders(Set.of(order));
//        productRepository.save(product);
//
//        Order order2 = new Order();
//        order2.setCustomer(customer);
//        Product product2 = new Product();
//        product2.setProductName("product 2");
//        //many to many olanda ortaq cedvele save getmir
//        product2.setOrders(Set.of(order, order2));
//        productRepository.save(product2);
        productService.getProductsByName("name").forEach(System.out::println);
    }
}