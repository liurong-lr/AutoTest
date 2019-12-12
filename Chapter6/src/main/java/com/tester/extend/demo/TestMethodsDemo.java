package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);

    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);

    }

    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");

    }
    @Test
    public void logdemo(){

        Reporter.log("这是我们自习写的日志");
// 抛出一个异常
        throw  new RuntimeException("这是我自己的运行时异常");

    }
}
