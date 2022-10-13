package com.example.demo.src.register;


import com.example.demo.config.BaseException;
import com.example.demo.src.register.model.*;
import com.example.demo.src.register.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

// Service Create, Update, Delete 의 로직 처리
@Service
public class RegisterService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());


    private final RegisterDao registerDao;
    private final RegisterProvider registerProvider;
//    private final JwtService jwtService;


    @Autowired
    public RegisterService(RegisterDao registerDao, RegisterProvider registerProvider) {
        this.registerDao = registerDao;
        this.registerProvider = registerProvider;
//        this.jwtService = jwtService;

    }


    /* 사장 등록 */
    public void addCeo(PostUserReq postUserReq) throws BaseException {

        try{
            int ceo_idx = registerDao.addCeo(postUserReq);

            if(ceo_idx == 0){
                throw new BaseException(POST_FAIL_CEO);
            }



        } catch (Exception exception) {
            System.out.println(exception);
            throw new BaseException(DATABASE_ERROR);
        }
    }





}
