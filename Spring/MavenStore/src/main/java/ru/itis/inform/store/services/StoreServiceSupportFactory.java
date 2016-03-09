package ru.itis.inform.store.services;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Moskieva on 09.03.16.
 */
public class StoreServiceSupportFactory {
    private static StoreServiceSupportFactory instance;
    private Properties properties;
    private StoreService storeService;

    private StoreServiceSupportFactory(){
        properties = new Properties();
        try {
            properties.load(
                    new FileInputStream("/Users/Moskieva/IdeaProjects/JavaHomeWorks/Spring/MavenStore/src/main/resources/item.properties"));
            String StroreServiceClass = properties.getProperty("service.class");
            this.storeService = (StoreService) Class.forName(StroreServiceClass).newInstance();
        }catch (Exception ex){
            throw  new IllegalArgumentException(ex);
        }
    }

    static {
        instance = new StoreServiceSupportFactory();
    }

    public static StoreServiceSupportFactory getInstance(){ return instance;}
    public StoreService getService(){return storeService;}



}