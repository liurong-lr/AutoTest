package com.couser.testng;

import org.testng.annotations.*;

import javax.xml.ws.BindingType;

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

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforclass这是在类运行之前运行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之后运行的方法");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforesuite测试套件");

    }
    @AfterSuite
    public void afterSuite(){

        System.out.println("aftersuite测试套件");
    }


}
