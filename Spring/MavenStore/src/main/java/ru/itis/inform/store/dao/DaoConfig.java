package ru.itis.inform.store.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DaoConfig {
    @Bean
    public static ItemsDao output(){
        ItemsDao itemsDao = new ItemsDaoFileBasedImpl();
        itemsDao.setItemsDaoInput(input());
        return itemsDao;
    }

    @Bean
    public static ItemsDaoInput input(){
        return new ItemsDaoCsvImpl();
    }
}
