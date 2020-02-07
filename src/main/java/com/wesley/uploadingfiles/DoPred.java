package com.wesley.uploadingfiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DoPred {
    public static String[] pred(String py_itp, String py_scp, String picPath) throws IOException{
        Process pr;
        String cmd = py_itp + " " + py_scp + " " + picPath;
        System.out.println(cmd);

        pr = Runtime.getRuntime().exec(cmd);

        InputStream is = pr.getInputStream(); // 获取perl进程的输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); // 缓冲读入
        StringBuilder buf = new StringBuilder(); // 保存perl的输出结果流
        String line = null;
        while((line = br.readLine()) != null) buf.append(line); // 循环等待进程结束
        System.out.println("算法输出内容为：" + buf);
        String[] ans_list = buf.toString().split(";");

        return ans_list;
    }
}
