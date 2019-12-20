package com.course.model;

import lombok.Data;

/**
 * @Author liurong
 * @Date 2019/12/18 17:52
 * @Version 1.0
 */
@Data
public class LoginCase {

    private int id;
    private String userName;
    private String password;
    private String expected;

}
