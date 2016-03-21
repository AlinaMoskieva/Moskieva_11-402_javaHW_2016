package ru.itis.inform.store.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.models.Item;

import java.util.List;


@Component
public class StoreServiceImpl implements StoreService {
    @Autowired
    @Qualifier("itemsDaoFileBasedImpl")
    private ItemsDao itemsDao;


    public void buy(String itemName) {
        itemsDao.deleteItem(itemName);

    }

    public boolean isExist(String itemName) {
        if(itemsDao == null)
            System.out.println("item null");
        return itemsDao.selectItemByName(itemName) != null;
    }


    public Item selectItemByName(String itemName) {
        return itemsDao.selectItemByName(itemName);
    }


    public List<Item> getItems() {
        return itemsDao.getItems();
    }


    public Item selectItemById(int id) {
        return itemsDao.selectItemById(id);
    }


    public void addItem(Item item) {
        itemsDao.addItem(item);

    }


}