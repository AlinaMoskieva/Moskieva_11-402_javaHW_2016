package ru.itis.inform.store.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;

import java.io.FileNotFoundException;
@ComponentScan("ru.itis.inform.store")
public class StoreServiceImpl implements StoreService {
    @Autowired
    private ItemsDao itemsDao;
    private static final Logger log = Logger.getLogger(StoreServiceImpl.class);

    public void buy(String itemName) {
        itemsDao.delete(itemName);
        log.info("purchase!");
    }

    public boolean isExist(String itemName) {

        log.info(itemName+ " was select");
        if(itemsDao == null)
            System.out.println("item null");
        return itemsDao.select(itemName) != null;
    }

}