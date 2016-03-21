package ru.itis.inform.store.services;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.store.AppConfiguration;
import ru.itis.inform.store.WebAppContext;

public class Program {
    static StoreService storeService;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebAppContext.class);
        StoreService service = context.getBean(StoreService.class);
        service.isExist("item0");

    }
}
