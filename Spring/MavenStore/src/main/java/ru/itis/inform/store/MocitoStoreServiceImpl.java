package ru.itis.inform.store;

import ru.itis.inform.store.dao.ItemsDaoFileBasedImpl;
import ru.itis.inform.store.dao.models.Item;
import ru.itis.inform.store.services.StoreServiceImpl;

import static org.mockito.Mockito.*;


public class MocitoStoreServiceImpl {

    public static void myMockito() {
      /*  ItemsDaoFileBasedImpl idfi = mock(ItemsDaoFileBasedImpl.class);
        StoreServiceImpl ser = new StoreServiceImpl();


        Item item = new Item();
        item.setCoast(" description");
        item.setName("it ");
        when( idfi.selectItemByName("it")).thenReturn(item);
        System.out.println("ItemsDaoFileBasedImpl mock  " + idfi.selectItemByName("it"));

        StoreServiceImpl ssimp = mock(StoreServiceImpl.class);
        when(ssimp.isExist("Item")).thenReturn(true);
        System.out.println("StoreServiceImpl mock  "+ ssimp.isExist("Item"));
    }


    /*public static void main (String [] args) throws FileNotFoundException {


        ItemsDaoFileBasedImpl idfi = new ItemsDaoFileBasedImpl("/Users/Moskieva/IdeaProjects/MavenStore/src/main/java/ru/itis/inform/store/services/list.txt");
        StoreServiceImpl ssimp = new StoreServiceImpl(idfi);
        idfi.read();
        myMockito();
        System.out.println("test ItemsDaoFileImpl  " + idfi.selectItemByName("it"));
        System.out.println("test StoreService "+ ssimp.isExist("Item"));
        ssimp.buy("товар");




    }*/
    }
}