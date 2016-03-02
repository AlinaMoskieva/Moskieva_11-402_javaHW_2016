package ru.itis.inform.store.services;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itis.inform.store.dao.ItemSupportFactory;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoInput;
import ru.itis.inform.store.dao.models.Item;

public class Program {
    public static void main(String[] args) {
      /*
       //Для propeties-файла
        ItemsDaoInput itemsDaoInput =
                ItemSupportFactory.getInstance().getInput();
        ItemsDao itemsDaoOutput =
                 ItemSupportFactory.getInstance().getOutput();
        itemsDaoInput.read();
        itemsDaoOutput.setItemsDaoInput( itemsDaoInput);
        Item item = new Item();
        item = itemsDaoOutput.select("item0");
        if (item!= null){
        System.out.println("Win!"+ item.getDescription()+"  "+item.getName());}
        else System.out.println("PAIN");*/
        //Spring
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        ItemsDao itemsDaoOutput =
                context.getBean("output", ItemsDao.class);
        ItemsDaoInput itemsDaoInput = context.getBean("input", ItemsDaoInput.class);
        itemsDaoInput.read();

        Item item =  itemsDaoOutput.select("item0");
        if (item!= null){
            System.out.println("Win!"+ item.getDescription()+"  "+item.getName());}
        else System.out.println("PAIN");

    }
}
