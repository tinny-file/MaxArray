package com.tba;

import java.io.*;

public class FileRead {
    //为保存的数组分配空间
    public static int[][] datas;
    public static int[][] SparseArrayFromFile(String path){
        //将稀疏矩阵从文件中读取出来
        BufferedReader br = null;
        BufferedReader br1 = null;
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(new File(path)));
            InputStreamReader isr1 = new InputStreamReader(new FileInputStream(new File(path)));
            br = new BufferedReader(isr);
            br1 = new BufferedReader(isr1);
            String res = null;
            int i = 1;
            int n,s;
            n = Integer.valueOf(br.readLine());//行
            s = Integer.valueOf(br.readLine());//列
            if(!isnumber(br1)){//判断是否存在非整数（*等符号）
                datas = new int[n+2][s+2];
                for (int x = 0;x < n+2;x++){
                    for (int y = 0;y < s+2;y++){
                        datas[x][y] = Integer.MAX_VALUE;
                    }
                }
            }else{
                //为保存的数组分配空间
                datas = new int[n+2][s+2];
                for(int x = 0;x < n+2;x++){
                    for (int y = 0;y < s+2;y++){
                        datas[x][y] = Integer.MIN_VALUE;
                    }
                }
                //按行读取
                while(null != (res = br.readLine())) {
                    if (null != res) {
                        //按行读取的字符串按逗号分割，得到一个String数组
                        String[] str = res.split(",");
                        //依此转为int型存入分配好的空间数组中
                        for (int k = 0; k < str.length; k++) {
                            //判断是否是负数，将其后的数直接强转为整型
                            if (str[k].charAt(0) == '-') {
                                String num = "";
                                for (int m = 1; m < str[k].length(); m++) {
                                    num += str[k].charAt(m);
                                }
                                int snum = Integer.valueOf(num);
                                datas[i][k+1] = -snum;
                            } else {//为正数时，直接强转为整型
                                datas[i][k+1] = Integer.valueOf(str[k]);
                            }
                        }
                        i++;//行数加1
                    }
                }
            }
            br.close();
            isr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }
    //判断是否存储不为数字的其他字符
    public static boolean isnumber(BufferedReader br){
        boolean flag = true;
        String res = "";
        try{
            int n = Integer.valueOf(br.readLine());
            int s = Integer.valueOf(br.readLine());
            while(null != (res = br.readLine())){
                if(res != null){
                    //按行读取的字符串按逗号分割，得到一个String数组
                    String[] str = res.split(",");
                    for(int i = 0;i < str.length;i++){
                        //判断是否存在字符，多个字符连接也可判断
                        if(str[i].charAt(0) == '-'){
                            for(int k = 1;k < str[i].length();k++){
                                if(str[i].charAt(k)-'0' < 10 && str[i].charAt(k)-'0' >= 0)
                                    continue;
                                else{
                                    flag = false;
                                    break;
                                }
                            }
                        }else{
                            for(int k = 0;k < str[i].length();k++){
                                if(str[i].charAt(k)-'0' < 10 && str[i].charAt(k)-'0' >= 0)
                                    continue;
                                else{
                                    flag = false;
                                    break;
                                }
                            }
                        }
                        if (!flag)
                            break;
                    }
                    if (!flag)
                        break;
                }
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
