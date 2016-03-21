package ru.itis.inform.store.dao;


import ru.itis.inform.store.dao.models.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class ItemsDaoTsvImpl implements ItemsDaoInput {
    private String tsvfileName;
    private List<Item> data;

    public ItemsDaoTsvImpl(){
        tsvfileName = "/Users/Moskieva/IdeaProjects/JavaHomeWorks/Spring/MavenStore/src/main/java/ru/itis/inform/store/services/TCVdata.txt";
        data = new ArrayList<Item>();
    }

    public void read() {
        System.out.println();
        File file = new File(tsvfileName);
        if ( file.exists() ) {
            try {
                BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
                try {
                    String s;
                    int id = -1;
                    while ((s = in.readLine()) != null) {
                        id++;
                        Item item =new Item();
                        StringTokenizer st = new StringTokenizer(s, " ");
                        item.setId(id);
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


    }

    public void write(String text) {
        File file = new File(tsvfileName);

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

    public void update(List<Item> data) {
        File file = new File(tsvfileName);
        Item item = new Item();
        if ( file.exists()){
            for ( int i=1; i< data.size(); i++)
                item = data.get(i);
            write(item.getName()+" "+item.getCoast());
        }

    }
    public List<Item> getData (){
        return data;
    }
}
