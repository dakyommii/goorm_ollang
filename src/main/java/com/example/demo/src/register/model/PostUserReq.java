package com.example.demo.src.register.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostUserReq {

        @ResponseBody
    @RequestMapping(value = "ceoRegi.do", method = RequestMethod.POST)
    public void memberRegi(HttpServletRequest request) {

//            setName(request.getParameter("name_give"));
            System.out.println("성공");

//        System.out.println(request.getParameter("name_give"));
//            System.out.println(request.getParameter("age_give"));
//        System.out.println(dto.getUserName());
//        System.out.println(userName);
    }



    private String name;
    private String gender;
    private String age;
    private String job;
    private String skill;
}
