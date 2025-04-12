package az.coders.spring.entitymanager.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_details")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;

    public ProductDetail(String description) {
        this.description = description;
    }

    public ProductDetail(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public ProductDetail() {
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
