package ru.itis.inform.store.dao.models;

import com.google.common.base.MoreObjects;
import java.util.Objects;

public class Item {
    private  String name;
    private  String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if ( obj == null || obj.getClass() != this.getClass())
            return false;

        Item that = (Item) obj;
        return Objects.equals( this.getName(), that.getName())&&
                Objects.equals( this.getDescription(), that.getDescription());

    }
    @Override
    public int  hashCode(){
        return Objects.hash(this.getName(), this.getDescription());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Description", this.description)
                .add("Name", this.name)
                .toString();

    }

}
