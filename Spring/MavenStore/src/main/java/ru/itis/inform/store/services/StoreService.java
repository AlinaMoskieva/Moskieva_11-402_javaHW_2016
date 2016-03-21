package ru.itis.inform.store.services;


import ru.itis.inform.store.dao.ItemsDao;
import ru.itis.inform.store.dao.models.Item;

import java.util.List;

public interface StoreService {
    /**
     * Покупка товара по имени
     * @param itemName имя товара
     */
    void buy(String itemName);

    /**
     * Проверяет, есть ли товар на складе
     * @param itemName название товара
     * @return true - если товар найден,
     * false - в противном случае
     */
    boolean isExist(String itemName);

    public Item selectItemByName(String itemName);

    /**
     * Возвращает список всех товаров
     * @return
     */
    public List<Item> getItems();

    /**
     * Возвращает описание товара из БД по id
     * @param id
     * @return
     */
    public Item selectItemById (int id);

    /**
     * добавляем товар в бд
     * @param item
     */
    public void addItem(Item item);

}