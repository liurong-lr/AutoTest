package com.course.model;

import lombok.Data;

/**
 * @Author liurong
 * @Date 2019/12/18 17:53
 * @Version 1.0
 */
@Data
public class UpdateUserInfoCase {

    private  int id;
    private  int userId;
    private String userName;
    private String sex;
    private String age;
    private String permission;
    private String IsDelete;
    private String expected;

}
