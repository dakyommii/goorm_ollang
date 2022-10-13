package com.example.demo.src.register.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostUserReq {
    private String name;
    private String gender;
    private String age;
    private String job;
    private String skill;
}
