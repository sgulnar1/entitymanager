package az.coders.spring.entitymanager.service.impl;

import az.coders.spring.entitymanager.entity.Product;
import az.coders.spring.entitymanager.repository.ProductRepository;
import az.coders.spring.entitymanager.service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
   // @Transactional
    public void save(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //entityManager.getTransaction().begin();
        product.setId(127);
        Product product1 = entityManager.find(Product.class, product.getId());
        entityManager.persist(product1);
        //entityManager.clear();
        product1.setProductName("new name 7");
        //entityManager.detach(product1);
        product1.setProductName("new name 8");
        product1.setProductName("new name 10");
        product1.setPrice(17.45);

//        entityManager.persist(product1);


//        Product product1 = entityManager.find(Product.class, product.getId());
//        product1.setProductName(product.getProductName());
//        System.out.println(entityManager.contains(product));
//        //System.out.println(entityManager.contains(product1));
//        entityManager.persist(product);
//        System.out.println("set product name before");
//        product.setProductName("xcvc ");
//        entityManager.flush();
//        product.setPrice(10.00);
//        System.out.println(entityManager.contains(product));
//        entityManager.detach(product);
//        System.out.println(entityManager.contains(product));
//        product.setPrice(52.55);
//        entityManager.persist(product);
//        entityManager.getTransaction().commit();

        //productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return findByProductNameWithSpesification(name);
    }

    private List<Product> findByProductNameWithSpesification(String name) {
        Specification<Product> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("productName"), name));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        return productRepository.findAll(spec);
    }

    private List<Product> findByProductNameWithCriteriaBuilder(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        Root<Product> product = query.from(Product.class);
        List<Predicate> predicates = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            predicates.add(criteriaBuilder.equal(product.get("productName"), name));
        }
        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }


}
