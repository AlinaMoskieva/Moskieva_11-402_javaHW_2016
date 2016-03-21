package ru.itis.inform.store.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreService;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public List<Item> getItems() {
        return storeService.getItems();
    }

    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable int id){
        return storeService.selectItemById(id);
    }

    @RequestMapping(value = "/items/{name}", method = RequestMethod.GET)
    public Item getItemByName(@PathVariable String name){
        return storeService.selectItemByName(name);
    }

    @RequestMapping(value = "/items/availability/{name}", method = RequestMethod.GET)
    public void itemAvailiability(@PathVariable String name){
        storeService.isExist(name);
    }

    @RequestMapping(value = "/items/purchase/{name}", method = RequestMethod.GET)
    public void buy(@PathVariable String name){
        storeService.buy(name);
    }

    @RequestMapping(value = "/items/new", method = RequestMethod.POST)
    public void addItem(@RequestBody Item item){
        storeService.addItem(item);
    }


}
