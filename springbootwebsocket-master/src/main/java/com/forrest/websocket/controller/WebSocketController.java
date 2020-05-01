package com.forrest.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.forrest.websocket.server.SocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * websocket
 * 消息推送(个人和广播)
 */
@Controller
public class WebSocketController {

    @Autowired
    private SocketServer socketServer;

    
    
    
    /**
     *
     * 客户端页面
     * @return
     */
    @RequestMapping(value = "/user")
    public String user(Model model) {
        int num = socketServer.getOnlineNum();
        List<String> list = socketServer.getOnlineUsers();
        model.addAttribute("num",num);
        model.addAttribute("users",list);
        return "user";
    }

    @RequestMapping(value = "/user1")
    public String user1(Model model) {
        return "user1";
    }

    /**
     *
     * 服务端页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin")
    public String admin(Model model) {
        int num = socketServer.getOnlineNum();
        List<String> list = socketServer.getOnlineUsers();
        model.addAttribute("num",num);
        model.addAttribute("users",list);
        return "admin";
    }
    @RequestMapping(value = "getOnline")
    public void onLine(HttpServletResponse response) throws IOException {
        int num = socketServer.getOnlineNum();
        List<String> list = socketServer.getOnlineUsers();

        
		Map<String,Object >map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("list", list);
        System.out.println("****users****");
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i)+"");
        }
        System.out.println("****num****");
        System.out.println(num);
        response.setContentType("text/plain");
        PrintWriter pr = response.getWriter();
        JSONObject json = new JSONObject(map);
        pr.print(json);
        pr.close();
     //   return "admin";
    }
    /**
     * 个人信息推送
     * @return
     */
    @RequestMapping("sendmsg")
    @ResponseBody
    public String sendmsg(String msg, String username){
        //第一个参数 :msg 发送的信息内容
        //第二个参数为用户长连接传的用户人数
        String [] persons = username.split(",");
        SocketServer.SendMany(msg,persons);
        return "success";
    }

    /**
     * 推送给所有在线用户
     * @return
     */
    @RequestMapping("sendAll")
    @ResponseBody
    public String sendAll(String username, String msg,String filename){
        SocketServer.sendAll(username,msg,filename);
        return "success";
    }
}
