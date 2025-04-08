package az.coders.spring.entitymanager.repository;

import az.coders.spring.entitymanager.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
}
