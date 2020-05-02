package com.forrest.websocket.common;

import java.io.*;
import java.util.*;

import org.springframework.util.ResourceUtils;


public class Common {
	public static volatile Queue<String> GAMEQUEUE = new LinkedList<String>();
	public static volatile List<String[]> READYLIST = new ArrayList<String[]>();
	public static volatile Map<String,Integer> MAINMAP = new HashMap<String, Integer>();
	public static volatile int MAIN = -1;
	public static int[][] QIPAN =null;
	public static String getUploadPath() throws FileNotFoundException {
		File path = new File(ResourceUtils.getURL("classpath:").getPath());
		File upload = new File(path.getAbsolutePath(),"image/upload/");
		if(!upload.exists()) upload.mkdirs();
		System.out.println("upload url:"+upload.getAbsolutePath());
		return upload.getAbsolutePath()+"/";
	}
	
}
