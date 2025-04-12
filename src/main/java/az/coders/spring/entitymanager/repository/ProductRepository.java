package az.coders.spring.entitymanager.repository;

import az.coders.spring.entitymanager.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    @Query("select p from Product  p where (p.productName = :name or :name is null)" +
            "and (p.id = :id or :id is null)")
    List<Product> findByProductName(String name);
//    @Query("select p from Product p " +
//            "left join fetch p.category " +
//            "left join  fetch  p.productDetail " +
//            "left join fetch p.orders")
    @Query("select p from Product p")
    @EntityGraph(attributePaths = {"category", "productDetail", "orders"})
    List<Product>findAll();
}
