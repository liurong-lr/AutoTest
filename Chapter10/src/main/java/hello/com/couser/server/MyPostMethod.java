package hello.com.couser.server;

import hello.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

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

    //验证cookies 和返回用户列表
    @RequestMapping(value = "/getUesrlist",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserlist(HttpServletRequest request,
                            @RequestBody User user){
        User user1;

        //获取cookies
        Cookie[] cookie=request.getCookies();
        //验证cookise是否合法   


        for (Cookie c:cookie) {

            if(c.getName().equals("login")&& c.getValue().equals("true")
                    && user.getUserName().equals("zhangshan")&& user.getPassWord().equals("123456")){
                   user1=new User();
                user1.setName("lisi");
                user1.setAge("18");
                user1.setSex("man");

                return  user1.toString();


            
        }
            
        }
        return  "参数不合法";
        }



    }



