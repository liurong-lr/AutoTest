package com.couser.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 什么时候会用到异常测试
     * 在我们期望结果为某一个异常的时候
     * 比如：我们传入了某个不合法的参数，程序抛了异常
     * 也就是我说的逾期结果就是这个异常
     */

      //这是一个测试结果会失败的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExecptionFailed(){
        System.out.println("这是一个运行失败的异常");
    }
    //这是一个成功的异常测试
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){

        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }

}


