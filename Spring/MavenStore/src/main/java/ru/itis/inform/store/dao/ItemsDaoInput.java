package ru.itis.inform.store.dao;

import ru.itis.inform.store.dao.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Ввод информации
 */
public interface ItemsDaoInput {
    /**
     * чтение информации из файла
     */
    void read();

    /**
     * запись информации в файл
     */
    void write(String text);

    /**
     * обновление информации
     */
    void update(List<Item> data);

    /**
     * получение прочитанной информации
     * @return массив информации из файла
     */
    List<Item> getData ();
}
