package com.forrest.websocket.util;

import com.forrest.websocket.common.Common;

public class TheadUtil {
	public static class MatchingThead extends Thread {

		private static String[] ready;
		
		@Override
		public void run() {
			while(true) {
				//System.out.println("***执行中***");
				while (Common.GAMEQUEUE.size() >= 2) {
					ready = new String[2];
					ready[0] = Common.GAMEQUEUE.poll();
					ready[1] = Common.GAMEQUEUE.poll();
					System.out.println(ready[0]+"  "+ready[1]);
					GameUtil.put(ready[0],ready[1]);
					Common.READYLIST.add(ready);
				}
				try {
					Thread.sleep(5 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

//	public static class MatchedThead extends Thread {
//		public boolean flag = false;
//		private String username;
//		public String against;
//		public int num = 0;
//		public MatchedThead(String username) {
//			this.username = username;
//		}
//
//		@Override
//		public void run() {
//			
//			while(!flag) {
//				for (String[] s : Common.READYLIST) {
//					if (username.equals(s[0])) {
//						against = s[1];
//						flag =true;
//						System.out.println("找到对手："+against);
//						break;
//					}
//					if (username.equals(s[1])) {
//						against = s[0];
//						flag =true;
//						System.out.println("找到对手："+against);
//						break;
//					}
//					
//				}
//				if(flag)
//					break;
//				if(++num>=20) {
//					System.out.println("匹配时间超时");
//					break;
//				}
//				try {
//					Thread.sleep(1 * 1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//	}
}
