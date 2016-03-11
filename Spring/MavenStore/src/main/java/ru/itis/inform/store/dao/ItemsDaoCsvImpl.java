package ru.itis.inform.store.dao;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
@ComponentScan("ru.itis.inform.store") //search the ru.itis.inform.store" package for @Component classes
@Component //Annotate to indicate this is class is an auto scan component.
public class ItemsDaoCsvImpl implements ItemsDaoInput {
    private String csvfileName;
    private ArrayList<Item> data;

    public ItemsDaoCsvImpl(){
        csvfileName = "/Users/Moskieva/IdeaProjects/JavaHomeWorks/Spring/MavenStore/src/main/java/ru/itis/inform/store/services/CSVdata.txt";
        data = new ArrayList<Item>();
    }

    public void read() {
        System.out.println("in read");
        File file = new File(csvfileName);
        if ( file.exists() ) {
            System.out.println("file exist");
            try {
                BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
                try {
                    System.out.println("in try");
                    String s;
                    while ((s = in.readLine()) != null) {
                        Item item =new Item();
                        StringTokenizer st = new StringTokenizer(s, ",");
                        item.setName(st.nextToken());
                        item.setDescription(s.replace(item.getName(),"").trim());
                        System.out.println("read:  "+item.getName()+item.getDescription());
                        data.add(item);
                    }
                } finally {
                    in.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void write(String text) {
        File file = new File(csvfileName);

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

    public void update(ArrayList<Item> data) {
        File file = new File(csvfileName);
        Item item = new Item();
        if ( file.exists()){
            for ( int i=1; i< data.size(); i++)
                item = data.get(i);
            write(item.getName()+","+item.getDescription());
        }

    }
    public ArrayList<Item> getData (){
        return data;
    }
}
