package com.example.demo.src.view;


import com.example.demo.config.BaseException;
import com.example.demo.src.view.ViewDao;
import com.example.demo.src.view.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class ViewProvider {

    private final ViewDao viewDao;
//    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ViewProvider(ViewDao viewDao) {
        this.viewDao = viewDao;
//        this.jwtService = jwtService;
    }

    //공고 조회
    public List<GetAnnounceRes> getAnnounce() throws BaseException {

        try{
            List<GetAnnounceRes> getAnnounce = viewDao.getAnnounce();
            return getAnnounce;
        } catch(Exception exception){
            System.out.println(exception);
            throw new BaseException(DATABASE_ERROR);
        }

    }

    //공고 상세 조회
    public List<GetDetailRes> getDetail() throws BaseException {

        try{
            List<GetDetailRes> getDetail = viewDao.getDetail();
            return getDetail;
        } catch(Exception exception){
            System.out.println(exception);
            throw new BaseException(DATABASE_ERROR);
        }

    }

    // 공고 정렬
    public List<GetAnnounceRes> getSort() throws BaseException {

        try{
            List<GetAnnounceRes> getSort = viewDao.getSort();
            return getSort;
        } catch(Exception exception){
            System.out.println(exception);
            throw new BaseException(DATABASE_ERROR);
        }

    }

    //검색 결과 조회
    public List<GetAnnounceRes> getSearch(GetSearchReq getSearchReq) throws BaseException {

        try{
            List<GetAnnounceRes> getSearch = viewDao.getSearch(getSearchReq);
            return getSearch;
        } catch(Exception exception){
            System.out.println(exception);
            throw new BaseException(DATABASE_ERROR);
        }

    }









}
