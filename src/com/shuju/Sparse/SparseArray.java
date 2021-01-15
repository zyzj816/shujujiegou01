package com.shuju.Sparse;

import java.util.ArrayList;
import java.util.List;

public class SparseArray {
    public static void main(String[] args) {
        //创建二维数组赋值并打印
        int ch1[][] = new int[11][11];
        ch1[1][2] = 1;
        ch1[2][3] = 2;
        System.out.println("原始的二维数组");
        for (int[] row : ch1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //定义sum记录有效数字的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (ch1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组并给稀疏数组首行赋值
        int ch_xs[][] = new int[sum + 1][3];
        ch_xs[0][0] = 11;
        ch_xs[0][1] = 11;
        ch_xs[0][2] = sum;
        //定义count把数据放入稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j<11; j++) {
                if (ch1[i][j] != 0) {
                    count++;
                    ch_xs[count][0] = i;
                    ch_xs[count][1] = j;
                    ch_xs[count][2] = ch1[i][j];
                }

            }
        }

        System.out.println("稀疏数组");
        for (int i=0;i<ch_xs.length;i++){
            System.out.printf("%d\t%d\t%d\n",ch_xs[i][0],ch_xs[i][1],ch_xs[i][2]);
        }
        //创建二维数组把稀疏数组中的信息放入并打印
        int ch2[][]=new int[ch_xs[0][0]][ch_xs[0][1]];
        for (int i=1;i<ch_xs.length;i++){
                ch2[ch_xs[i][0]][ch_xs[i][1]]=ch_xs[i][2];
        }
        for (int[] row:ch2
             ) {
            for (int data:row
                 ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
List li=new ArrayList();

}