package com.shuju.queue;

import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
        int a=0;
        Arrqueue arr=new Arrqueue(3);
        char key=' ';
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while(loop){
        System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):向队列中添加数据");
            System.out.println("g(get):获取队列中数据");
            System.out.println("h(head):显示队列头的数据");
            key=sc.next().charAt(0);
            switch (key){
                case 's':
                    arr.show();
                    break;
                case 'e':
                    sc.close();
                    loop=false;
                    break;
                case 'a':
                    System.out.println("请输入一个数:");
                    int value=sc.nextInt();
                    System.out.printf("这个数是%d",value);
                    arr.addarr(value);
                    break;
                case 'g':
                    try {
                        int res=arr.getque();
                        System.out.printf("取出的数据是:%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':

                    try {
                        int res= arr.head();
                        System.out.printf("队列头的数据是:%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
    class Arrqueue{
    private int maxsize;//表示数组的最大容量
    private  int read;//表示队列尾部
    private int front;//表示队列头部
    private int[] arr;//数组


        public  Arrqueue(int arrMaxSize){
            maxsize=arrMaxSize;
            read=-1;//指向队列的尾部;
            front=-1;//指向队列的头部
            arr=new int[maxsize];
        }
        //判断队列是否满了
        public boolean isFull(){
            return read==maxsize-1;
        }
        //判断队列是否为空
        public boolean isEmpty(){
            return read==front;
        }
        //添加数据到队列
        public void addarr(int n){
            //判断队列是否满
            if(isFull()){
                System.out.println("队列满了,无法加入数据");
            }
            //让队列尾向后移动一位并赋值
            System.out.println(n);
            read++;
            arr[read]=n;
        }
        //获取队列数据(出队列)
        public int getque(){
            //首相判断队列是否为空才能取出数据
            if(isEmpty()){
                throw new RuntimeException("队列为空,无法取出数据");
            }
            return arr[++front];
        }
        //显示队列的数据
        public void show(){
            //判断是否为空
            if(isEmpty()){
                System.out.println("队列空的,没有数据");
                return;
            }
            for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
            }
        }
        //显示队列的头信息
        public int head(){
            if(isEmpty()){
                throw  new RuntimeException("队列为空,无数据");
            }
            return arr[front+1];
        }
    }