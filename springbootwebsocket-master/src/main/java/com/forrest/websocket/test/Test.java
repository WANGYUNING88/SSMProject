package com.forrest.websocket.test;

import java.util.HashMap;
import java.util.Map;

import com.forrest.websocket.common.Common;
import com.forrest.websocket.util.GameUtil;

public class Test {
	
	public static boolean CheckWin(int xIndex, int yIndex,int[][] a) {
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
	
	public static void main(String[] args) {
//		String[] s = new String[2];
//		System.out.println("s1是："+s[1]);
//		Map<String ,Integer> map = new HashMap<String ,Integer>();
//		map.put("1", 3);
//		System.out.println(map.remove("1"));
		int [] a1 = {0,0,0,0,0,0,0,0,0,0};
		int [] a2 = {0,0,0,0,0,0,0,0,0,0};
		int [] a3 = {0,0,0,2,0,0,0,0,0,0};
		int [] a4 = {0,0,0,1,1,0,0,0,0,0};
		int [] a5 = {0,0,0,2,1,2,0,0,1,0};
		int [] a6 = {0,1,1,1,0,1,2,1,0,0};
		int [] a7 = {0,0,1,2,2,1,2,2,0,0};
		int [] a8 = {0,0,1,1,2,1,0,0,0,0};
		int [] a9 = {0,1,0,2,1,2,0,0,0,0};
		int [] a0 = {0,0,0,0,0,1,0,0,0,0};
		int[][] a = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a0};
	//	System.out.println(GameUtil.isWin(a));
		System.out.println(CheckWin(5,1,a));
	}

}
