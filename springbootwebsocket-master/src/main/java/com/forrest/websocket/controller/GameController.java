package com.forrest.websocket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.forrest.websocket.common.Common;
import com.forrest.websocket.server.SocketServer;
import com.forrest.websocket.util.GameUtil;
import com.forrest.websocket.util.TheadUtil;

@Controller
public class GameController {
	
	@RequestMapping(value = "/test")
	public String test() {

        return "test";
    }
	@RequestMapping(value = "/wuziqi")
    public String matched() {

        return "wuziqi";
    }
	@RequestMapping(value = "/choose")
    @ResponseBody
    public String sendmsg(String chessmen, String against){
		String n = "black";
		if(chessmen.equals("black")) {
			n="white";
		}
        SocketServer.SendChoose(n,against);
        return chessmen;
    }
	/**
	 * 下棋每一步//新建的数组默认0；白色的2；黑色的1
	 * @param chessmen
	 * @param against
	 * @return
	 */
	@RequestMapping(value = "/xiaziqi")
    @ResponseBody
    public int xiaqi(int x,int y,String color, String against){
		
		int i = color.equals("white")?2:1;
		int result = -1;
		Common.QIPAN[x][y]=i;
		boolean a = GameUtil.checkWin(x, y, Common.QIPAN);
		if(a) {
			result =i;
		}else{
			result = GameUtil.isDraw();
		}
		//GameUtil.printPipan();
		int[] position = {x,y,result};
        SocketServer.SendQizi(position,against);
        System.out.println(color+":"+position[0]+" , "+position[1]);
        return result;
    }
	/**
	 * 
	 * @param username 对手的id
	 * @return
	 */
	@RequestMapping(value = "/reset")
    @ResponseBody
    public synchronized int reset(String username,String against){
		System.out.println(username+" 重开");
		if(Common.MAINMAP.containsKey(username)) {
			int a= Common.MAINMAP.get(username);
			SocketServer.SendReset(against,1-a);
			Common.MAINMAP.remove(username);
			GameUtil.initChess();
			return a;
		}
		else {
			GameUtil.put(username, against);
			return Common.MAINMAP.remove(username)+3;
		}
		
    }

	
	private Queue<Map<Integer,Object >> queue = new LinkedList<Map<Integer,Object >>();
	@RequestMapping(value = "/matching")
    public  void  matching(HttpServletResponse response,String username) throws IOException {
		if(GameUtil.isExist(username))
			return;
		Map<Integer,Object >map = new HashMap<Integer, Object>();
		map.put(0, response);
		map.put(1, username);
		queue.add(map);

		while(!queue.isEmpty()) {
			map = queue.poll();
			response= (HttpServletResponse) map.get(0);
			username = (String) map.get(1);
			
			if(username!="")
				Common.GAMEQUEUE.add(username);
			System.out.println("username:"+username);
	        match(response, username);
		}
        
		
    }
	
	public  void match(HttpServletResponse response,String username) throws IOException {
		
		response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
		String against = "";
		boolean flag = false;
		int num= 0;
		int main =-1;
		
		while(!flag) {
			for (String[] s : Common.READYLIST) {
				if (username.equals(s[0])) {
					against = s[1];
					flag =true;
					//main =0;
					System.out.println("找到对手："+against);
					break;
				}
				if (username.equals(s[1])) {
					against = s[0];
					flag =true;
				//	main = 1;
					System.out.println("找到对手："+against);
					break;
				}
				
			}
			if(flag) {
				GameUtil.initChess();
			
				main = Common.MAINMAP.get(username);
				Common.MAINMAP.remove(username);
				break;
			}
			if(++num>=20) {
				Common.GAMEQUEUE.poll();
				System.out.println("匹配时间超时");
				break;
			}
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        Map<String,Object >map = new HashMap<String, Object>();

        
        map.put("flag", flag);
        map.put("main", main);
        if(!flag) {
        	map.put("msg", "匹配时间超时");
        }else {
        	map.put("msg", against);
        }
        JSONObject json = new JSONObject(map);
        System.out.println(json.toString());
        PrintWriter pr = response.getWriter();
        pr.print(json);
        
        pr.close();
		
	}
}
