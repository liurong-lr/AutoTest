package hello.com.couser.server;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    public String getcookies(HttpServletResponse response) {

        //HttpServerletRequest  装请求信息得类
        //HttpServerletResponse 装响应信息

        Cookie cookie = new Cookie("login", "true");
        //添加cookies信息
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     * <p>
     * 这是一个需要携带cookies信息才能访问得get请求
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request) {


        Cookie[] cookies = request.getCookies();
       //判断对象是否为空
        if (Objects.isNull(cookies)) {

            return "你需要携带cookies";

        }

        for (Cookie cookie : cookies) {
            //判断cookies得name 和value同时满足
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookies信息才能访问得get请求";
            }
        }

          return "你必需携带cookies信息";
    }

    /**
     * 开发一个需要携带参数才能访问得get请求
     * 第一种实现 url :key=value&key=value
     * 我们来模拟获取商品列表
     */

     @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    public Map<String,Integer> getList(@RequestParam Integer start, @RequestParam Integer end ){

        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面", 1);
        myList.put("衬衣",300);
        return myList;


    }

    /**
     * 第二种需要携带参数访问得get请求
     * url:ip:port/get/with/parm/10/20
     */

    @RequestMapping(value = "/get/with/param/{start}/{end}")
    public  Map myGetList(@PathVariable Integer start, @PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面", 1);
        myList.put("衬衣",300);
        return myList;



    }
}