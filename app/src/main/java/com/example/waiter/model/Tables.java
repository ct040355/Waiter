package com.example.waiter.model;

import java.io.Serializable;

public class Tables implements Serializable {
    private String table;
    private int imageTable;

    public Tables(String table, int imageTable) {
        this.table = table;
        this.imageTable = imageTable;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public int getImageTable() {
        return imageTable;
    }

    public void setImageTable(int imageTable) {
        this.imageTable = imageTable;
    }
}
