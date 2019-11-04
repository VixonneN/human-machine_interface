package com.example.myapplication.data_class;

public class TypeOfConnectionData {
    private int id;
    private String type;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public TypeOfConnectionData(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
