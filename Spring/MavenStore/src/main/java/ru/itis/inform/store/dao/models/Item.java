package ru.itis.inform.store.dao.models;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class Item {
    private  String name;
    private  String coast;
    private  int id;

    public Item(String name, String coast, int id) {
        this.name = name;
        this.coast = coast;
        this.id = id;
    }
    public Item(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoast() {
        return coast;
    }

    public void setCoast(String coast) {
        this.coast = coast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == null || obj.getClass() != this.getClass())
            return false;

        Item that = (Item) obj;
        return Objects.equals( this.getName(), that.getName())&&
                Objects.equals( this.getCoast(), that.getCoast());

    }
    @Override
    public int  hashCode(){
        return Objects.hash(this.getName(), this.getCoast(), this.getId());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Coast", this.coast)
                .add("Name", this.name)
                .add("Id", this.id)
                .toString();

    }

}
