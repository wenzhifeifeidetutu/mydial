package com.mycompany.mydial;

/**
 * Created by Administrator on 2017/6/4.
 */

public class Connector {

    private String name;
    private String phone_number;
    private String time;


    public Connector(String name, String phone_number, String time){
        this.name = name;
        this.phone_number = phone_number;
        this.time = time;

    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getTime() {
        return time;
    }
}
