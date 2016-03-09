package ru.itis.inform.store.services;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.itis.inform.store.dao.*;


@Configuration
@Import(DaoConfig.class)
public class ServicesConfig {

    @Bean
    public StoreService service(){
        return new StoreServiceImpl(DaoConfig.output());
    }

}
