package ru.itis.inform.store;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.itis.inform.store.dao.*;
import ru.itis.inform.store.services.StoreService;
import ru.itis.inform.store.services.StoreServiceImpl;

@Configuration
@ComponentScan("ru.itis.inform.store")
public class AppConfiguration {

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
