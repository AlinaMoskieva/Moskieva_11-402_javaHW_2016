package ru.itis.inform.store.services;

import org.apache.log4j.Logger;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;

import java.io.FileNotFoundException;

public class StoreServiceImpl implements StoreService {

    private ItemsDao itemsDao;
    private static final Logger log = Logger.getLogger(StoreServiceImpl.class);
// for Spring

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
//for properties
    public void setItemsDao(ItemsDao input) {
        this.itemsDao = input;
        if (itemsDao == null)
        System.out.println("set not work");
    }


}