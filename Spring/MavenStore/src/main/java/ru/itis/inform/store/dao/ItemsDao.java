package ru.itis.inform.store.dao;
import ru.itis.inform.store.dao.models.Item;

import java.util.List;

public interface ItemsDao {

    /**
     * Удаляет товар из хранилища
     * @param itemName
     */
    void deleteItem(String itemName);

    /**
     * Возвращает описание товара из БД по имени
     * @param itemName
     * @return
     */
    Item selectItemByName(String itemName);

    /**
     * Возвращает список всех товаров
     * @return
     */
    List<Item> getItems();

    /**
     * Возвращает описание товара из БД по id
     * @param id
     * @return
     */
    Item selectItemById (int id);

    /**
     * добавляем товар в бд
     * @param item
     */
    void addItem(Item item);


}
