package com.wang.controller;

import com.wang.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回值是字符串类型
     * @param model
     * @return
     */
    @RequestMapping("testString")
    public String testString(Model model){
        System.out.println("【testString】 执行了...");
        User user = new User("王余柠", "123", 24);
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 返回值是void
     * 他会默认请求对应原来路径jsp页面，如/springmvc_day02_01_response_war/WEB-INF/pages/user/testVoid.jsp
     * 我们可以使用转发一次请求到指定的jsp页面，这里我们需要指定完整的jsp路径，系统不会使用视图解析器.
     * 也可以使用重定向,不可以访问web-inf路径下的文件；
     * 还可以直接向客户端详细；
     * @param request
     * @return
     */
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("【testVoid】 执行了...");
        //1.请求一次转发，然后return;
/*
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
*/
        //2.重定向
/*
        response.sendRedirect(request.getContextPath()+"/index.jsp");
*/
        //3.直接响应
        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好");
        return;
    }

    /**
     * testModelAndView
     * @return
     */
    @RequestMapping("testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("【testModelAndView】 执行了...");
        //创建modelandview对象
        ModelAndView modelAndView = new ModelAndView();
        //模拟从数据库查询结果
        User user = new User("王余柠", "486258", 24);
        //把结果存到modelAndView中,也会把user存到request域中
        modelAndView.addObject("user",user);
        //跳转到指定到指定的页面,使用的是视图解析器
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 使用关键字的方法进行转发和重定向
     * @return
     */
    @RequestMapping("testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("【testForwardOrRedirect】 执行了...");
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和响应的过程
     * @return
     */
    @RequestMapping("testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("【testAjax】 执行了...");
        //客户端发送的ajax的请求，传入的参数是json字符串，后端把json封装到实体类中
        System.out.println(user);
        //模拟数据库的操作
        user.setUsername("测试修改");
        user.setAge(18);
        //做出响应
        return user;

    }

}
