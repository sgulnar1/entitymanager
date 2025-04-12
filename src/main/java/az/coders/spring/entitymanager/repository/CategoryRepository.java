package az.coders.spring.entitymanager.repository;

import az.coders.spring.entitymanager.entity.Category;
import az.coders.spring.entitymanager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
