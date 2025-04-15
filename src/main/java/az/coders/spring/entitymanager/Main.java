package az.coders.spring.entitymanager;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("start method: " + new Date());
        try {
            List<Object> list = new ArrayList<>();
            ReferenceQueue referenceQueue = new ReferenceQueue<>();
            for (int i = 1; i <= 1000000000; i++) {
                list.add(new PhantomReference<>(i, referenceQueue));
                if (i % 1000000 == 0) {
                    System.out.println("list  size: " + list.size());
                    System.out.println("before: " + ((PhantomReference) list.get(i-1)).get());
                    System.gc();
                    System.out.println("after: " + referenceQueue.poll().get());
                }
            }
            System.out.println("end method: " + new Date());
        } catch (Error e) {
            System.out.println("end method with error: " + new Date());
        }
    }

}
