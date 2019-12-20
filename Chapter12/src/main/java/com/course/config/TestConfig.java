package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @Author liurong
 * @Date 2019/12/18 18:03
 * @Version 1.0
 */
public class TestConfig {

    public static String loginUrl;
    public  static String updateUserInfoUrl;
    public  static String getUserListUrl;
    public  static String getUserInfoUrl;

    public  static String addUserUrl;

  public  static DefaultHttpClient defaultHttpClient;
  public static CookieStore store;


}
