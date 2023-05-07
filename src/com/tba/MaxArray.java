package com.tba;

public class MaxArray {
    public static void main(String[] args) {
        FileRead fd = new FileRead();
        int[][] datas = fd.SparseArrayFromFile("D:\\IDEA\\Workspaces\\MaxArray\\data\\4.txt");
        int res = Integer.MIN_VALUE;
        if (!isnum(datas)){
            System.out.println("字符存储错误");
        }else {
            int[][] ary = new int[datas.length][datas[0].length];
            for (int i = 1; i < datas.length - 1; i++) {//行
                for (int j = 1; j < datas[0].length - 1; j++) {//列
                    ary = memset(datas, ary);
                    res = Math.max(res, array(i, j, ary, Integer.MIN_VALUE));
                }
            }
            System.out.println(res);
        }
    }
    //复制数组
    public static int[][] memset(int[][] datas,int[][] ary){
        for(int i = 0;i < datas.length;i++){
            for(int j = 0;j < datas[0].length;j++){
                ary[i][j] = datas[i][j];
            }
        }
        return ary;
    }
    //求最大子数组
    /**
     * 算法思路：
     *      找到每一个点的相邻点中的最大值(上、下、左、右)，相加，存储最大值，加一位数，将其更替为最小值，防止回走
     * */
    public static int array(int x,int y,int[][] datas,int temp){
        int len = (datas.length-1)*(datas[0].length-1);
        int res = Integer.MIN_VALUE;
        temp = datas[x][y];
        int m = x,n = y;
        for(int i = 0;i < len;i++){
            res = Math.max(res,temp);
            datas[m][n] = Integer.MIN_VALUE;
            if(datas[m-1][n] > datas[m+1][n] && datas[m-1][n] > datas[m][n+1] && datas[m-1][n] > datas[m][n-1]){//上
                if(datas[m+1][n] > 0 && datas[m+1][n] != Integer.MIN_VALUE){
                    temp += datas[m+1][n];
                    datas[m+1][n] = Integer.MIN_VALUE;
                }else if(datas[m][n-1] > 0 && datas[m][n-1] != Integer.MIN_VALUE){
                    temp += datas[m][n-1];
                    datas[m][n-1] = Integer.MIN_VALUE;
                }else if(datas[m][n+1] > 0 && datas[m][n+1] != Integer.MIN_VALUE){
                    temp += datas[m][n+1];
                    datas[m][n+1] = Integer.MIN_VALUE;
                }
                temp += datas[m-1][n];
                m = m - 1;
                n = n;
            }else if(datas[m+1][n] > datas[m-1][n] && datas[m+1][n] > datas[m][n-1] && datas[m+1][n] > datas[m][n+1]){//下
                if(datas[m-1][n] > 0 && datas[m-1][n] != Integer.MIN_VALUE){
                    temp += datas[m-1][n];
                    datas[m-1][n] = Integer.MIN_VALUE;
                }else if(datas[m][n+1] > 0 && datas[m][n+1] != Integer.MIN_VALUE){
                    temp += datas[m][n+1];
                    datas[m][n+1] = Integer.MIN_VALUE;
                }else if(datas[m][n-1] > 0 && datas[m][n-1] != Integer.MIN_VALUE){
                    temp += datas[m][n-1];
                    datas[m][n-1] = Integer.MIN_VALUE;
                }
                temp += datas[m+1][n];
                m = m + 1;
                n = n;
            }else if(datas[m][n-1] > datas[m+1][n] && datas[m][n-1] > datas[m-1][n] && datas[m][n-1] > datas[m][n+1]){//左
                if(datas[m-1][n] > 0 && datas[m-1][n] != Integer.MIN_VALUE){
                    temp += datas[m-1][n];
                    datas[m-1][n] = Integer.MIN_VALUE;
                }else if(datas[m+1][n] > 0 && datas[m+1][n] != Integer.MIN_VALUE){
                    temp += datas[m+1][n];
                    datas[m+1][n] = Integer.MIN_VALUE;
                }else if(datas[m][n+1] > 0 && datas[m][n+1] != Integer.MIN_VALUE){
                    temp += datas[m][n+1];
                    datas[m][n+1] = Integer.MIN_VALUE;
                }
                temp += datas[m][n-1];
                m = m;
                n = n - 1;
            }else if(datas[m][n+1] > datas[m+1][n] && datas[m][n+1] > datas[m-1][n] && datas[m][n+1] > datas[m][n-1]){//右
                if(datas[m-1][n] > 0 && datas[m-1][n] != Integer.MIN_VALUE){
                    temp += datas[m-1][n];
                    datas[m-1][n] = Integer.MIN_VALUE;
                }else if(datas[m][n-1] > 0 && datas[m][n-1] != Integer.MIN_VALUE){
                    temp += datas[m][n-1];
                    datas[m][n-1] = Integer.MIN_VALUE;
                }else if(datas[m+1][n] > 0 && datas[m][n+1] != Integer.MIN_VALUE){
                    temp += datas[m+1][n];
                    datas[m+1][n] = Integer.MIN_VALUE;
                }
                temp += datas[m][n+1];
                m = m;
                n = n + 1;
            }
            datas[m][n] = Integer.MIN_VALUE;
        }
        return res;
    }
    //判断数组是否存在其他字符
    public static boolean isnum(int[][] datas){
        boolean flag = true;
        if(datas[0][0] == Integer.MAX_VALUE)
            flag = false;
        return flag;
    }
}
