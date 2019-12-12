package com.couser.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider ="data" )
    public  void testDataProvider(String name ,int age){

        System.out.println("name"+name+";age"+age);

    }
    @DataProvider(name = "data")
    public Object[][]providerData(){

        Object[][]o=new Object[][]{

                {"zhangshan",10},
                {"lisi",20},
                {"wangwu",20}

        };
        return  o ;
    }

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test1方法 name="+name+";age"+age);

    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2方法 name="+name+";age"+age);


    }
    @DataProvider(name = "methodData")
    public Object[][]methodDataTest(Method method){
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result=new Object[][]{
                    {"zhangsan",20},
                    {"lisi",25}

            };


        }else if(method.getName().equals("test2")){
            result=new Object[][]{
                    {"liurong",20},
                    {"wupan",10}
            };

        }
        return  result;


    }

}
