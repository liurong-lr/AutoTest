package com.course.model;

import lombok.Data;

/**
 * @Author liurong
 * @Date 2019/12/18 15:10
 * @Version 1.0
 */
@Data
public class User {

    private  int id;
    private  String userName;
    private  String password;

    private  String age;
    private String sex;
    private  String permission;
    private  String isDelete;

    public String toString(){
        return (

                "id:"+id+","+
                        "userName:"+userName+","+
                        "age:"+age+","+
                        "sex:"+sex+","+
                        "permission:"+permission+","+
                        "isDelete:"+isDelete+","+
                        "password:"+password+","





        );
    }
}
