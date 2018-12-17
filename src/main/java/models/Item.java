package models;

public class Item {
    int code;
    String name;
    Groups groupItem;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Groups getGroupItem() {
        return groupItem;
    }

    public void setGroupItem(Groups groupItem) {
        this.groupItem = groupItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
