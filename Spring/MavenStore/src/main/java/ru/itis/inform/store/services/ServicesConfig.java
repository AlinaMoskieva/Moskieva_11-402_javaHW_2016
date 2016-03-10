package ru.itis.inform.store.services;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.itis.inform.store.dao.*;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;


@Configuration
public class ServicesConfig {
    @Bean
    public ItemsDao getOutput(){
        return new ItemsDaoFileBasedImpl();
    }
    @Bean
    public ItemsDaoInput Csv(){
        return new ItemsDaoCsvImpl();
    }
    @Bean
    public ItemsDaoInput getTsv(){
        return new ItemsDaoTsvImpl();
    }


    @Bean
    public StoreService getService(){
        return new StoreServiceImpl();
    }

}
