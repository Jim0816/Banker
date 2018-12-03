package com.ljm.banker;
import java.util.Map;

public class Progress {
    String pname;
    //该进程中某个资源对应的参数分配，int[]中依次为：该进程当前得到资源数、当前所需资源数
    Map<String,int[]> resTables = null;

    Progress(String pname,Map<String,int[]> resTables){
        this.pname = pname;
        this.resTables = resTables;
    }
}
