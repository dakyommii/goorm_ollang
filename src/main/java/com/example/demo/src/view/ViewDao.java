package com.example.demo.src.view;


import com.example.demo.src.register.model.PostUserReq;
import com.example.demo.src.view.model.GetAnnounceRes;
import com.example.demo.src.view.model.GetDetailRes;
import com.example.demo.src.view.model.GetSearchReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ViewDao {

    private JdbcTemplate jdbcTemplate;
//    private List<GetAnnounceRes> getAnnounceRes;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 공고 조회
    public List<GetAnnounceRes> getAnnounce(){
        String getAnnounceQuery="select title, onoff,compny_name as company,a_location as location,date_format(start_time,'%y:%m:%d-%H:%i') as start_time,total_time,pay from announce;";

        return this.jdbcTemplate.query(getAnnounceQuery,
                (rs, rowNum) -> new GetAnnounceRes(
                        rs.getString("title"),
                        rs.getString("onoff"),
                        rs.getString("company"),
                        rs.getString("location"),
                        rs.getString("start_time"),
                        rs.getInt("total_time"),
                        rs.getInt("pay")

                )
        );
    }

    // 공고 상세 조회
    public List<GetDetailRes> getDetail(){
        String getDetailQuery="select title, a_category as category, onoff,compny_name as company,a_location as location,date_format(start_time,'%y:%m:%d-%H:%i') as start_time,total_time,content,pay from announce;";

        return this.jdbcTemplate.query(getDetailQuery,
                (rs, rowNum) -> new GetDetailRes(
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getString("onoff"),
                        rs.getString("company"),
                        rs.getString("location"),
                        rs.getString("start_time"),
                        rs.getString("content"),
                        rs.getInt("total_time"),
                        rs.getInt("pay")

                )
        );
    }


    // 시간순 정렬
    public List<GetAnnounceRes> getSort(){

        //시간순
        String getSortQuery="select title, onoff,compny_name as company,a_location as location,start_time,total_time,pay from announce order by start_time;";

        return this.jdbcTemplate.query(getSortQuery,
                (rs, rowNum) -> new GetAnnounceRes(
                        rs.getString("title"),
                        rs.getString("onoff"),
                        rs.getString("company"),
                        rs.getString("location"),
                        rs.getString("start_time"),
                        rs.getInt("total_time"),
                        rs.getInt("pay")

                )
        );
    }

    public List<GetAnnounceRes> getSearch(GetSearchReq getSearchReq){
        String getSearchQuery="select title, onoff,compny_name as company,a_location as location,date_format(start_time,'%m:%d-%H:%i') as start_time,total_time,pay from announce where title like?;";
        String getSearchParam= '%'+getSearchReq.getKeyword()+'%';

        return this.jdbcTemplate.query(getSearchQuery,
                (rs, rowNum) -> new GetAnnounceRes(
                        rs.getString("title"),
                        rs.getString("onoff"),
                        rs.getString("company"),
                        rs.getString("location"),
                        rs.getString("start_time"),
                        rs.getInt("total_time"),
                        rs.getInt("pay"))
                ,getSearchParam
        );
    }




}
