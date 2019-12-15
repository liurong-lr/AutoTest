package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {


    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息得变量
    private CookieStore store;


    @BeforeTest
    public void beforeTest() {

        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中拼接测试得URL
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;
        //测试逻辑代码书写
        HttpGet get = new HttpGet(testUrl);
        //DefaultHttpClient才有cookis信息
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name=" + name + "," + "cookie value=" + value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public  void testPostMehtod() throws IOException {

        String uri=bundle.getString("test.post.with.cookies");
        //拼接URL
        String testurl=this.url+uri;
        //声明一个client对象，用来进行方法得执行
        DefaultHttpClient client =new DefaultHttpClient();
        //声明一个方法，这个方法就是post放
        HttpPost post =new HttpPost(testurl);
        //添加参数
        JSONObject param =new JSONObject();
        param.put("name","liurong");
        param.put("age","18");

        //设置请求信息,设置header,

        post.setHeader("content-tpye","application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象，来进行响应结果得存储
         String result;
        //设置cookies信息
        client.setCookieStore(this.store);

        //执行post方法
       HttpResponse response= client.execute(post);
        //获取响应结果
         result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result="+result);
        //处理结果,就是判断返回结果是否符合逾期
        //将响应得结果字符串转换成json对象
        JSONObject resultJson=new JSONObject(result);

        //获取返回值
        String sucecess= (String) resultJson.get("liurong");
        String status= (String) resultJson.get("status");


        //具体得判断返回结果得值
        Assert.assertEquals("success",sucecess);
        //实际结果与逾期结果比较.前面是逾期结果，后面是实际结果。
        Assert.assertEquals("1",status);






    }
}
