package com.couser.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1 执行");

    }
    //忽略不执行
    @Test(enabled = false)
    public void  igonre1(){

        System.out.println("ignore2 执行");
    }
//执行
    @Test(enabled = true)
  public  void ignore3(){
      System.out.println("ignore3 执行");
  }
}
