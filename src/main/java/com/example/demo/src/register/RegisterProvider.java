package com.example.demo.src.register;


import com.example.demo.config.BaseException;
import com.example.demo.src.register.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

//Provider : Read의 비즈니스 로직 처리
@Service
public class RegisterProvider {

    private final RegisterDao registerDao;
//    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public RegisterProvider(RegisterDao registerDao) {
        this.registerDao = registerDao;
//        this.jwtService = jwtService;
    }








}
