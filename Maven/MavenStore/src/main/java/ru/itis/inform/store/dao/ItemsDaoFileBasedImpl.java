package ru.itis.inform.store.dao;

import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ItemsDaoFileBasedImpl implements ItemsDao{
    // TODO: реализовать класс, возможно с использованием
    // сериализации ArrayList, либо просто считывать данные из
    // файла в ArrayList
    private  ArrayList<Item> data = new ArrayList<Item>();
    private  String fileName;
    public ItemsDaoFileBasedImpl(String fileName){
        this.fileName = fileName;

    }


    /**
     * метод для чтения данных с файла
     * @return ArrayList со списком
     * @throws FileNotFoundException
     */
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
                        item.setDescription(s.replace(item.getName(),"").trim());
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
     */
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
     */
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

    public void delete(String itemName) {
        for (int i=0; i< data.size();i++){
            if (data.get(i).getName().equals(itemName)) {
                data.remove(i);
                try {
                    update(data);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * возвращает описание товара
     * @param itemName
     * @return
     */
    public Item select(String itemName) {
        int index=-1;
        for (int i =0; i < data.size(); i++){
            if(data.get(i).getName().equals(itemName)){
                index=i;}}
        if(index == -1 ) return null;
        else
            return data.get(index);
    }
}