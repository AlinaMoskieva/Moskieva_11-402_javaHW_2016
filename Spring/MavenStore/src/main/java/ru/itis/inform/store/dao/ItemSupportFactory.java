package ru.itis.inform.store.dao;


import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreService;

import java.io.FileInputStream;
import java.util.Properties;

public class ItemSupportFactory {
    // Поле - инстанс(экземпляр) нашей фабрики
    private static ItemSupportFactory instance;

    // здесь будут храниться параметры наших классов
    private Properties properties;

    private ItemsDao output;
    private ItemsDaoInput input;

    private ItemSupportFactory() {
        properties = new Properties();

        try {
            properties.load(
                    new FileInputStream("/Users/Moskieva/IdeaProjects/JavaHomeWorks/Spring/MavenStore/src/main/resources/item.properties"));

            String ItemsDaoInputClass = properties.getProperty("input.class");
            String ItemsDaoClass = properties.getProperty("output.class");

            this.input = (ItemsDaoInput) Class.forName(ItemsDaoInputClass).newInstance();
            this.output = (ItemsDao) Class.forName(ItemsDaoClass).newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
    }

    static {
        instance = new ItemSupportFactory();
    }

    public static ItemSupportFactory getInstance() {
        return instance;
    }

    public ItemsDao  getOutput() {
        return output;
    }

    public ItemsDaoInput getInput() {
        return input;
    }
}
