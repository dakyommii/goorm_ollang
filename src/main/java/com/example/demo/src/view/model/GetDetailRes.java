package com.example.demo.src.view.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetDetailRes {
    private String title;
    private String category;
    private String onoff;
    private String company;
    private String location;
    private String start_time;
    private String content;
    private int total_time;
    private int pay;
//    private List<String> imgs;

}





