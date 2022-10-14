package com.example.demo.src.view;


import com.example.demo.config.BaseException;
import com.example.demo.src.view.ViewDao;
import com.example.demo.src.view.ViewProvider;
import com.example.demo.src.view.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

// Service Create, Update, Delete 의 로직 처리
@Service
public class ViewService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final ViewDao viewDao;
    private final ViewProvider viewProvider;
//    private final JwtService jwtService;


    @Autowired
    public ViewService(ViewDao viewDao, ViewProvider viewProvider) {
        this.viewDao = viewDao;
        this.viewProvider = viewProvider;
//        this.jwtService = jwtService;

    }










}
