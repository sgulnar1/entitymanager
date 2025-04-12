package az.coders.spring.entitymanager;

import java.util.Date;

public class MainServiceProxy implements MainService {
    MainServiceImpl mainServiceImpl = new MainServiceImpl();
    @Override
    public String sayHello() {
        Date startDate = new Date();
        String s = mainServiceImpl.sayHello();
        Date endDate = new Date();
        System.out.println("service time: " + (endDate.getTime() - startDate.getTime()));
        return s;
    }
}
