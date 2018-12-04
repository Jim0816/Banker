package com.ljm.banker;
/*
 * 测试
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		String [][] input = {
								{"p0","A","0","7"},
								{"p0","B","1","5"},
								{"p0","C","0","3"},
								
								{"p1","A","2","3"},
								{"p1","B","0","2"},
								{"p1","C","0","2"},
								
								{"p2","A","3","9"},
								{"p2","B","0","0"},
								{"p2","C","2","2"},
								
								{"p3","A","2","2"},
								{"p3","B","1","2"},
								{"p3","C","1","2"},
								
								{"p4","A","0","4"},
								{"p4","B","0","3"},
								{"p4","C","2","3"},
							};
		Map<String, Progress> result = dealParas.deal(input);
		Map<String,Integer> availables = new HashMap<>();
		availables.put("A", 3);
		availables.put("B", 3);
		availables.put("C", 2);
		while(result.size()>0) {
			String successPro = null;
			for (Object key : result.keySet()) {
				//得到当前进程
				//System.out.println("进程"+key.toString()+"===================================");
				Progress progress= result.get(key);
				Set resKeys = progress.resTables.keySet();
				//boolean check = true;//假设所有资源满足条件 
				int resNums = progress.resTables.size();//该进程所需要的资源种类数量
				int count = 0;//记录资源满足的种类
				for (Object resKey : resKeys) {
					//得到当前资源对象
					String resName = resKey.toString();
					int [] para = progress.resTables.get(resKey);
					if(availables.get(resName) > para[1] || availables.get(resName) == para[1]) {
						count++;
					}
					//判断该资源是否满足分配条件
					//System.out.println("资源"+resName+": "+"当前得到:"+para[0]+"  "+"当前需要:"+para[1]);
				}
				
				if(count==resNums) {
					//说明所有资源的分配条件满足
					for (Object resKey : resKeys) {
						String resName = resKey.toString();
						int [] para = progress.resTables.get(resKey);
						availables.put(resName,availables.get(resName)+para[0]);
					}
					//该进程得到资源后完成工作，从容器中删除成功进程
					System.out.println("进程"+key+"执行成功!");
					successPro = key.toString();
					break;
				}
			}
			result.remove(successPro);
		}	
	}

}
