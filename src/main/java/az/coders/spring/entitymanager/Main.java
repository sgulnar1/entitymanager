package az.coders.spring.entitymanager;

import lombok.Data;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        MainServiceProxy mainServiceProxy = new MainServiceProxy();
        System.out.println(mainServiceProxy.sayHello());
      }
}
