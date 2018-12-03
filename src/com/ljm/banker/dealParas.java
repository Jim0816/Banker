package com.ljm.banker;

import java.util.HashMap;
import java.util.Map;


public class dealParas {
	
    public static Map<String,Progress> deal(String [][]input){
    	//输入格式:{"进程名","资源名","当前得到资源数","最大需求数"}
    	Map<String,Progress> resTables = new HashMap<>();
    	//根据进程名创建各自进程的容器
        for (int i=0;i<input.length;i++){
        	//得到当前行，得到各项参数
        	String[] theRow = input[i];
        	String pName = theRow[0];//进程名
        	String resName = theRow[1];//资源名
        	//第一个为当前得到资源数，第二个为当前所需要资源数 = 最大需求数-当前得到资源数
        	int[] thePara = {Integer.valueOf(theRow[2]),Integer.valueOf(theRow[3])-Integer.valueOf(theRow[2])};
        	
        	if(resTables.containsKey(pName)) {
        		//该进程容器已经创建了，并且该数据属于本进程
        		//获取该进程
        		Progress theProgress = resTables.get(pName);
        		//添加数据
        		theProgress.resTables.put(resName,thePara);
        	}else {
        		//该进程容器未被创建,开始创建
        		Map<String,int[]> newMap = new HashMap<>();
        		newMap.put(resName,thePara);
        		Progress progress = new Progress(pName, newMap);
        		resTables.put(pName, progress);	
        	}  
        }
        return resTables;
    }
}
