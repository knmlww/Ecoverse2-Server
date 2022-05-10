package com.example.demo.api.DemoDTO;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoDTO {
    private int id;
    private String name;
    private String subject;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSubject(){
        return subject;
    }


}
