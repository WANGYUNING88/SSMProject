package com.forrest.websocket.util;

import com.forrest.websocket.common.Common;

public class GameUtil {
	
	public static boolean checkWin(int xIndex, int yIndex,int[][] a) {
        int max = 0;
        int tempXIndex = xIndex;
        int tempYIndex = yIndex;
        int count=1;
        boolean flag = false;
        // 三维数组记录横向，纵向，左斜，右斜的移动
        int[][][] dir = new int[][][] {
                // 横向
                { { -1, 0 }, { 1, 0 } },
                // 竖着
                { { 0, -1 }, { 0, 1 } },
                // 左斜
                { { -1, -1 }, { 1, 1 } },
                // 右斜
                { { 1, -1 }, { -1, 1 } } };
 
        for (int i = 0; i < 4; i++) {
            count = 1;
            //j为0,1分别为棋子的两边方向，比如对于横向的时候，j=0,表示下棋位子的左边，j=1的时候表示右边
            for (int j = 0; j < 2; j++) {
                flag = true;
                /**
                 while语句中为一直向某一个方向遍历
                 有相同颜色的棋子的时候，Count++
                 否则置flag为false，结束该该方向的遍历
                 **/
                while (flag) {
                    tempXIndex = tempXIndex + dir[i][j][0];
                    tempYIndex = tempYIndex + dir[i][j][1];
 
                    //这里加上棋盘大小的判断，这里我设置的棋盘大小为20 具体可根据实际情况设置 防止越界
                    if (tempXIndex >= 0 && tempXIndex < a.length && tempYIndex >= 0 && tempYIndex < a.length) {
                        if ((a[tempXIndex][tempYIndex] == a[xIndex][yIndex])) {
                            count++;
                            System.out.println(count);
                        }
                        else
                            flag = false;
                    }else{
                        flag = false;
                    }
                    
                }
                tempXIndex = xIndex;
                tempYIndex = yIndex;
            }
 
            if (count >= 5) {
                max = 1;
                break;
            } else
                max = 0;
        }
        if (max == 1)
            return true;
        else
            return false;
    }
	
	public static void printPipan() {
		for(int i=0;i<Common.QIPAN.length;i++) {
			for(int j=0;j<Common.QIPAN[i].length;j++) {
				System.out.print(Common.QIPAN[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void initChess() {
		Common.QIPAN = new int[16][16];
	}
	public static boolean isExist(String username) {
		return Common.GAMEQUEUE.contains(username)&&Common.MAINMAP.containsKey(username)&&Common.READYLIST.contains(username);
	}

	public static void put(String username,String username2) {
		int a = getMain();
		Common.MAINMAP.put(username, a);
		Common.MAINMAP.put(username2, 1-a);
	}
	/**
	 * 确定先手
	 * @return
	 */
	public static int getMain() {
		return (int)(0+Math.random()*(1-0+1));
	}
	/**
	 * 判断输赢
	 * @param a
	 * @return -1：和局；0：暂无人；
	 */
	public static int isDraw() {
		int[][] a= Common.QIPAN;
		// 横向
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(a[i][j]==0)
					return 0;
			}
		}
		return -1;
		
	}
}
