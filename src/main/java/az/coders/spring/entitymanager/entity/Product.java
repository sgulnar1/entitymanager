package az.coders.spring.entitymanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
@FieldNameConstants
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq", sequenceName = "products_id_seq", initialValue = 100, allocationSize = 1)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    @NotEmpty
    private String productName;
    @Transient
    private String test;
    private double price;
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private ProductDetail productDetail;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//        @JoinTable(name = "orders_products",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Order> orders;

    public Product(String productName, ProductDetail productDetail, Category category) {
        this.productName = productName;
        this.productDetail = productDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotEmpty String getProductName() {
        return productName;
    }

    public void setProductName(@NotEmpty String productName) {
        this.productName = productName;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", test='" + test + '\'' +
                ", price=" + price +
                ", productDetail=" + productDetail +
                ", category=" + category +
                ", orders=" + orders +
                '}';
    }

    public Product(int id, String productName, ProductDetail productDetail) {
        this.id = id;
        this.productName = productName;
        this.productDetail = productDetail;
    }

    public Product() {
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
