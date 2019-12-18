package com.couser.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author liurong
 * @Date 2019/12/16 17:49
 * @Version 1.0
 */
@Log4j
@RestController
@Api(value ="v1",description = "这是我的第一个版本得demo")
@RequestMapping("v1")
public class demo {

    //获取一个执行sql语句得对象
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUsercount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public  int getUsercount(){
      return   template.selectOne("getUserCount");


    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public int addUser(@RequestBody User user){
      int result=  template.insert("addUser",user);
      return  result;


    }
//更新
@RequestMapping(value = "/updataUser",method = RequestMethod.POST)
public int updateUser(@RequestBody User user){

       return template.update("updataUser",user);
    }


    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public int delUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }

}
