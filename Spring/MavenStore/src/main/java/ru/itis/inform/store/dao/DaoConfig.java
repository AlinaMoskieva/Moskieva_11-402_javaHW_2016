package ru.itis.inform.store.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DaoConfig {

    @Bean
    public ItemsDao getOutput(){
        ItemsDao itemsDao = new ItemsDaoFileBasedImpl();
        itemsDao.setItemsDaoInput(getCsv());
        return itemsDao;
    }

    @Bean
    public ItemsDaoInput getCsv(){
        return new ItemsDaoCsvImpl();
    }
    @Bean
    public ItemsDaoInput getTsv(){
        return new ItemsDaoTsvImpl();
    }

}
