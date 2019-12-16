package hello.com.couser.server;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liurong
 * @Date 2019/12/15 21:42
 * @Version 1.0
 */
@RestController
@Api(value = "/",description = "这是我全部得post请求")
@RequestMapping("/v1")
public class MyPostMethod {

    //这个变量是用来装我们cookies信息得
    private  static Cookie cookie;
    //用户登录成功获取到cookies,然后再访问其他接口接口获取到列表

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  String login(HttpServletResponse response,
                         @RequestParam(value = "userName",required = true)  String userName ,
                         @RequestParam (value = "password",required = true) String password){
    if(userName.equals("zhangshan") && password.equals("123456")){
          cookie=new Cookie("login","true");
        return "恭喜你登录成功";
        }
        return "用户名或者密码错误";

    }


}
