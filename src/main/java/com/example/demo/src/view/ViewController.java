package com.example.demo.src.view;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.view.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/view")
public class ViewController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ViewProvider viewProvider;
    @Autowired
    private final ViewService viewService;
//    @Autowired
//    private final JwtService jwtService;




    public ViewController(ViewProvider viewProvider, ViewService viewService){
        this.viewProvider = viewProvider;
        this.viewService = viewService;
//        this.jwtService = jwtService;
    }

    /* 조회 */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<List<GetAnnounceRes>> getAnnounce() {
        try{
            List<GetAnnounceRes> getAnnounce=viewProvider.getAnnounce();

            return new BaseResponse<>(getAnnounce);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /* 시간순 정렬 */
    @ResponseBody
    @GetMapping("/sort")
    public BaseResponse<List<GetAnnounceRes>> getSort() {
        try{
            List<GetAnnounceRes> getSort=viewProvider.getSort();

            return new BaseResponse<>(getSort);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /* 상세 조회 */
    @ResponseBody
    @GetMapping("/detail")
    public BaseResponse<List<GetDetailRes>> getDetail() {
        try{
            List<GetDetailRes> getDetail=viewProvider.getDetail();

            return new BaseResponse<>(getDetail);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }


    // 거리 정렬

    // 시간 정렬

    // 가격순 정렬


    /* 검색 */
    @ResponseBody
    @GetMapping("/search")
    public BaseResponse<List<GetAnnounceRes>> getSearch(GetSearchReq getSearchReq) {

        //키워드 공백 check
        if(getSearchReq.getKeyword()== null){
            return new BaseResponse<>(ANNOUNCEMENT_EMPTY_SEARCH_KEYWORD);
        }

        try{

            List<GetAnnounceRes> getSearch=viewProvider.getSearch(getSearchReq);

            return new BaseResponse<>(getSearch);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    // ceo 정보





}
