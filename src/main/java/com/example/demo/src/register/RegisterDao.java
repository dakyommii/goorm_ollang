package com.example.demo.src.register;


import com.example.demo.src.register.model.PostUserReq;

import com.example.demo.src.register.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RegisterDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public int addCeo(PostUserReq postUserReq){
        String createCeoQuery = "insert into ceo (c_name,c_gender,c_age,c_job,c_skill) VALUES (?,?,?,?,?)";
        Object[] createCeoParams = new Object[]{postUserReq.getName(),postUserReq.getGender(),postUserReq.getAge(),postUserReq.getJob(),postUserReq.getSkill()};
        this.jdbcTemplate.update(createCeoQuery, createCeoParams);

        String lastInsertIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery,int.class);

    }

    public int addWorker(PostUserReq postUserReq){
        String createWorkerQuery = "insert into worker (w_name,w_gender,w_age,w_job,w_skill) VALUES (?,?,?,?,?)";
        Object[] createWorkerParams = new Object[]{postUserReq.getName(),postUserReq.getGender(),postUserReq.getAge(),postUserReq.getJob(),postUserReq.getSkill()};
        this.jdbcTemplate.update(createWorkerQuery, createWorkerParams);

        String lastInsertIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInsertIdQuery,int.class);

    }





}
