package ru.itis.inform.store.services;

import org.apache.log4j.Logger;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;

import java.io.FileNotFoundException;

public class StoreServiceImpl implements StoreService {

    ItemsDao itemsDao;
    private static final Logger log = Logger.getLogger(StoreServiceImpl.class);

    public StoreServiceImpl(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    public void buy(String itemName) {
        itemsDao.delete(itemName);
        log.info("purchase!");
    }

    public boolean isExist(String itemName) {

        log.info(itemName+ " was select");
        return itemsDao.select(itemName) != null;
    }



}