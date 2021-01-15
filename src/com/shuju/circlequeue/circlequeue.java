package com.shuju.circlequeue;

import java.util.Scanner;

public class circlequeue {
    public static void main(String[] args) {
        circle arr=new circle(4);
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
class circle{
    private int maxsize;//表示数组的最大容量
    private  int read;//表示队列尾部
    private int front;//表示队列头部
    private int[] arr;//数组


    public  circle(int arrMaxSize){
        maxsize=arrMaxSize;
        read=0;//环形队列尾的调整read指向队列的最后一个元素的后一个位置,因为此时希望空出一个空间作为约定,read初始值为0;
        front=0;//环形队列头的调整:front指向队列的第一个元素,也就是说arr[front]是第一个元素,front初始值为0
        arr=new int[maxsize];
    }
    //判断队列是否满了
    public boolean isFull(){
        return (read+1)%maxsize==front;
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
        }else{
        //直接将数据加入队列
        System.out.println("前"+read);
        arr[read]=n;
        System.out.println("后"+read);
        //将read的值后移,用取模的方式来达到环形的概念
            read=(read+1)%maxsize;
        }

    }
    //获取队列数据(出队列)
    public int getque(){
        //首相判断队列是否为空才能取出数据
        if(isEmpty()){
            throw new RuntimeException("队列为空,无法取出数据");
        }
        /*
        * 1.首先需要将front的值保留到一个临时的变量中
        * 2.将front后移,考虑取模
        * 3.将临时保存的变量返回
        * */
        int value=arr[front];
        front=(front+1)%maxsize;
        return value;
    }
    //显示队列的数据
    public void show(){
        //判断是否为空
        if(isEmpty()){
            System.out.println("队列空的,没有数据");
            return;
        }
        for(int i=front;i<front+size();i++){
            //为什么是i%maxsize?因为这是一个环形的队列
            System.out.printf("arr[%d]=%d\n",i%maxsize,arr[i%maxsize]);
        }
    }
    public int size(){
        return (read+maxsize-front)%maxsize;
    }
    //显示队列的头信息
    public int head(){
        if(isEmpty()){
            throw  new RuntimeException("队列为空,无数据");
        }
        return arr[front];
    }
}
