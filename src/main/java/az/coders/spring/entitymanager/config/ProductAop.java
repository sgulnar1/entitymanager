package az.coders.spring.entitymanager.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
    @After("execution(java.util.List<az.coders.spring.entitymanager.entity.Product> getProductsByName2(..))")
    public void afterMethod() {
        System.out.println("getProductsByName end ...");
    }
    @Around("execution(java.util.List<az.coders.spring.entitymanager.entity.Product> get*(..))")
    public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("getProductsByName around start");
        joinPoint.proceed();
        System.out.println("getProductsByName around end");
    }

    @Around("@annotation(az.coders.spring.entitymanager.annotation.Readable)")
    public void aroundReadMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("ANNOTATION START");
        joinPoint.proceed();
        System.out.println("ANNOTATION END");
    }
}
