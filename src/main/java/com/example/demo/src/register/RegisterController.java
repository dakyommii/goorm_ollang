package com.example.demo.src.register;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.register.RegisterProvider;
import com.example.demo.src.register.RegisterService;
import com.example.demo.src.register.model.PostUserReq;
//import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.demo.config.BaseResponseStatus.*;

@RestController
@RequestMapping("/register")
public class RegisterController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final RegisterProvider registerProvider;
    @Autowired
    private final RegisterService registerService;
//    @Autowired
//    private final JwtService jwtService;




    public RegisterController(RegisterProvider registerProvider, RegisterService registerService){
        this.registerProvider = registerProvider;
        this.registerService = registerService;
//        this.jwtService = jwtService;
    }



    /* 정보 등록 */
    // ceo 정보
    @ResponseBody
    @PostMapping("/ceo")
    public BaseResponse<String> addCeo(@RequestBody PostUserReq postUserReq) {

        //닉네임 공백 check
        if(postUserReq.getName() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_NAME);

        //성별 공백 check
        if(postUserReq.getGender() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_GENDER);

        //나이 공백 check
        if(postUserReq.getAge() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_AGE);

        //직업 공백 check
        if(postUserReq.getJob() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_JOB);

        //분야 공백 check
        if(postUserReq.getSkill() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_SKILL);

        //닉네임 길이 check
        if(postUserReq.getName().length()>15)
            return new BaseResponse<>(POST_USERS_INVALID_LEN);

        try{

            registerService.addCeo(postUserReq);

            String str = "성공적으로 등록되었습니다.";
            return new BaseResponse<>(str);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    // ceo 정보
    @ResponseBody
    @PostMapping("/worker")
    public BaseResponse<String> addWorker(@RequestBody PostUserReq postUserReq) {

        //닉네임 공백 check
        if(postUserReq.getName() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_NAME);

        //성별 공백 check
        if(postUserReq.getGender() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_GENDER);

        //나이 공백 check
        if(postUserReq.getAge() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_AGE);

        //직업 공백 check
        if(postUserReq.getJob() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_JOB);

        //분야 공백 check
        if(postUserReq.getSkill() == null)
            return new BaseResponse<>(POST_USERS_EMPTY_SKILL);

        //닉네임 길이 check
        if(postUserReq.getName().length()>15)
            return new BaseResponse<>(POST_USERS_INVALID_LEN);

        try{

            registerService.addWorker(postUserReq);

            String str = "성공적으로 등록되었습니다.";
            return new BaseResponse<>(str);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }




}
