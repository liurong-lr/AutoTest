package com.couser.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    //最基本的注解，用来把方法标记为
    @Test
    public  void testcase1(){
        System.out.println("这是测试用例1");

    }
    @Test
     public  void  testcase2(){

         System.out.println("这是测试用例2");
     }
    @BeforeMethod
    public  void  beforeMethod(){
        System.out.println("beforemethod这是在测试方法之前运行的");
    }
   @AfterMethod
    public void afterMethod(){
        System.out.println("aftermethod这是在测试方法之后运行的");
    }

}
