package ru.itis.inform.store.services;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.store.dao.ItemSupportFactory;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoInput;
import ru.itis.inform.store.dao.models.Item;

public class Program {
    public static void main(String[] args) {
                //Spring Annotation
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(ServicesConfig.class);
        StoreService storeService = (StoreService) ctx.getBean("service");
        System.out.println( "Answer from store service:    " + storeService.isExist("item0"));





        /*


                //Для propeties-файла
        ItemsDaoInput itemsDaoInput =
                ItemSupportFactory.getInstance().getInput();
        ItemsDao itemsDaoOutput =
                 ItemSupportFactory.getInstance().getOutput();
        itemsDaoOutput.setItemsDaoInput(itemsDaoInput);

        StoreService storeService = StoreServiceSupportFactory.getInstance().getService();
        if (itemsDaoInput == null)
            System.out.println("itemDaoInput is null in main");

        itemsDaoOutput.setItemsDaoInput(itemsDaoInput);
        storeService.setItemsDao(itemsDaoOutput);

        System.out.println("itemDaoOutput "+ itemsDaoOutput.select("item0"));
        System.out.println("store service "+ storeService.isExist("item0"));

        */

        /* itemsDaoInput.read();
        itemsDaoOutput.setItemsDaoInput( itemsDaoInput);
        Item item = new Item();
        item = itemsDaoOutput.select("item0");
        if (item!= null){
        System.out.println("Win!"+ item.getDescription()+"  "+item.getName());}
        else System.out.println("PAIN");
                                 //Spring for dao

       /* ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        ItemsDao itemsDaoOutput =
                context.getBean("output", ItemsDao.class);
        ItemsDaoInput itemsDaoInput = context.getBean("input", ItemsDaoInput.class);
        itemsDaoInput.read();*/

/*
                             //Spring new version
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");
        StoreService service = (StoreService) context.getBean("service");

        System.out.println(service.isExist("item"));
        System.out.println(service.isExist("item0"));
        System.out.println(service.isExist("item1"));*/

    }
}
