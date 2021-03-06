package ru.itis.inform.store.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;
import java.util.ArrayList;
import java.util.List;


@Component
public class ItemsDaoFileBasedImpl implements ItemsDao{

    private  List<Item> data = new ArrayList<Item>();
    @Autowired
    private ItemsDaoInput input;




    public void deleteItem(String itemName) {
        if(input!= null){
            getData();
            for (int i=0; i< data.size();i++){
                if (data.get(i).getName().equals(itemName)) {
                    data.remove(i);
                    try {
                        input.update(data);
                    } catch (Exception e) {
                        System.out.println("Ooops. I'm on ItemsDaoFaleBasedImpl");
                    }
                }

            }
        }else throw new RuntimeException();
    }

    /**
     * производится чтение с файла
     */
    public void getData(){
        this.data = input.getData();
    }

    /**
     * возвращает описание товара
     * @param itemName
     * @return
     */
    public Item selectItemByName(String itemName) {
        System.out.println("in selectItemByName");
        input.read();
        if (input != null){
            System.out.println("input  exist");
            getData();
            int index=-1;
            for (int i =0; i < data.size(); i++){
                if(data.get(i).getName().equals(itemName)){
                    index=i;}}
            if(index == -1 ) return null;
            else
                return data.get(index);}
        else throw new RuntimeException();
    }


    public List<Item> getItems() {
        getData();
        return data;
    }


    public Item selectItemById(int id) {
        System.out.println("in selectItemById");
        input.read();
        if (input != null){
            System.out.println("input is exist");
            getData();
            int index=-1;
            for (int i =0; i < data.size(); i++){
                if(data.get(i).getId() == id){
                    index=i;}}
            if(index == -1 ) return null;
            else
                return data.get(index);}
        else throw new RuntimeException();
    }


    public void addItem(Item item) {
        input.read();
        if (input!= null){
            getData();
            data.add(item);
            try {
                input.update(data);
            } catch (Exception e){
                System.out.println("Oops .. I'm in addItem");
            }
        }else  throw new RuntimeException("Input isn't exist");

    }

}

/*
    /**
     * метод для чтения данных с файла
     * @return ArrayList со списком
     * @throws FileNotFoundException
     *
    public  ArrayList<Item> read () throws FileNotFoundException {
        File file = new File(fileName);
        if ( file.exists() ) {
            try {
                BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
                try {
                    String s;
                    while ((s = in.readLine()) != null) {
                        Item item =new Item();
                        StringTokenizer st = new StringTokenizer(s, " ");
                        item.setName(st.nextToken());
                        item.setCoast(s.replace(item.getName(),"").trim());
                        data.add(item);
                    }
                } finally {
                    in.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }
        return data;
    }

    /**
     * для обновления данных в файле
     * @param data данные для записи
     * @throws FileNotFoundException
     *
    public void update(ArrayList<Item> data) throws FileNotFoundException {
        File file = new File(fileName);
        Item item = new Item();
        if ( file.exists()){
            for ( int i=1; i< data.size(); i++)
                item = data.get(i);
            write(item.getName()+" "+item.getDescription());
        }
    }

    /**
     * для записи данных
     * @param text строка для записи
     *
    public void write (String text) {
        File file = new File(fileName);

        if (file.exists()) {
            try {
                PrintWriter out = new PrintWriter(file.getAbsoluteFile());

                try {
                    out.print(text);
                } finally {
                    out.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    /**
     * удаляет товар из списка и обновляет файл
     * @param itemName
     */


