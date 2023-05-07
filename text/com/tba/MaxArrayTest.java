package com.tba;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxArrayTest extends MaxArray {
    private MaxArray ma;
    private FileRead fr;
    @Test
    public void array1() {
        int[][] datas = fr.SparseArrayFromFile("D:\\IDEA\\Workspaces\\MaxArray\\data\\1.txt");
        int res = Integer.MIN_VALUE;
        int[][] ary = new int[datas.length][datas[0].length];
        for(int i = 1;i < datas.length-1;i++){//行
            for(int j = 1;j < datas[0].length-1;j++){//列
                ary = memset(datas,ary);
                res = Math.max(res,array(i,j,ary,Integer.MIN_VALUE));
            }
        }
        assertEquals(res,-1);
    }
    @Test
    public void array2() {
        int[][] datas = fr.SparseArrayFromFile("D:\\IDEA\\Workspaces\\MaxArray\\data\\2.txt");
        int res = Integer.MIN_VALUE;
        int[][] ary = new int[datas.length][datas[0].length];
        for(int i = 1;i < datas.length-1;i++){//行
            for(int j = 1;j < datas[0].length-1;j++){//列
                ary = memset(datas,ary);
                res = Math.max(res,array(i,j,ary,Integer.MIN_VALUE));
            }
        }
        assertEquals(res,23);
    }
    @Test
    public void array3() {
        int[][] datas = fr.SparseArrayFromFile("D:\\IDEA\\Workspaces\\MaxArray\\data\\3.txt");
        assertEquals(isnum(datas),false);
    }
    @Test
    public void array4() {
        int[][] datas = fr.SparseArrayFromFile("D:\\IDEA\\Workspaces\\MaxArray\\data\\4.txt");
        int res = Integer.MIN_VALUE;
        int[][] ary = new int[datas.length][datas[0].length];
        for(int i = 1;i < datas.length-1;i++){//行
            for(int j = 1;j < datas[0].length-1;j++){//列
                ary = memset(datas,ary);
                res = Math.max(res,array(i,j,ary,Integer.MIN_VALUE));
            }
        }
        assertEquals(res,25);
    }
}
