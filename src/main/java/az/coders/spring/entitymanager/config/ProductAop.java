package az.coders.spring.entitymanager.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProductAop {
    @Before("execution(java.util.List<az.coders.spring.entitymanager.entity.Product> getProductsByName(..))")
    public void beforeMethod() {
        System.out.println("getProductsByName start ...");
    }
    @After("execution(java.util.List<az.coders.spring.entitymanager.entity.Product> getProductsByName(..))")
    public void afterMethod() {
        System.out.println("getProductsByName end ...");
    }
}
