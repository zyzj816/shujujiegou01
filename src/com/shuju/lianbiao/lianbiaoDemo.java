package com.shuju.lianbiao;

public class lianbiaoDemo {
    public static void main(String[] args) {
        HeroNode h1=new HeroNode(1,"宋江","及时雨");
        HeroNode h2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode h3=new HeroNode(3,"无用","智多星");
        HeroNode h4=new HeroNode(4,"林冲","豹子头");
        lianbiao lianbiao=new lianbiao();
//        lianbiao.add(h1);
//        lianbiao.add(h2);
//        lianbiao.add(h3);
//        lianbiao.add(h4);
        lianbiao.addorder(h1);
        lianbiao.addorder(h2);
        lianbiao.addorder(h3);
        lianbiao.addorder(h3);
        lianbiao.addorder(h4);
        lianbiao.lis();
        HeroNode h5=new HeroNode(2,"小卢","玉麒麟~~");
        lianbiao.update(h5);
        //修改之后
        lianbiao.lis();
    }

}
//创建单链表,定义lianbiao来管理数据
class lianbiao{
    //先初始化头结点,头结点不能动(如果头结点变化了,遍历的时候就找不到链表最顶端)
    private HeroNode head=new HeroNode(0,"","");
    //添加节点到单向链表
    //当不考虑编号顺序时
    //1.找到链表最后的节点
    //2.将这个节点的next指向新的节点
    //因为头结点不能动所以此时需要一个辅助节点来遍历
    public void add(HeroNode heronode) {
        HeroNode temp = head;
        //(1)遍历节点找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
                //如果没有找到就将temp后移
                temp = temp.next;

        }
        //(2)当退出while时temp就指向最后了
        temp.next=heronode;
        System.out.println("添加成功");
    }

    //使用遍历来确定到要添加的位置
    public void addorder(HeroNode heroNode){
        HeroNode temp=head;
        boolean flag=false;
        while (true){
             if(temp.next==null){//此时已经在链表的最后
                 break;
             }
             if(temp.next.no>heroNode.no){//说明此时的位置已经找到了就在temp的后面插入
                break;
             }else if(temp.next.no==heroNode.no){//说明编号存在
                flag=true;
                break;
             }
             temp=temp.next;
        }
        //判断flag的值
        if(flag){//不能添加,说明编号存在
            System.out.println("准备添加的编号"+heroNode.no+"已经存在了,无法添加");
        }else{
            //插入到链表中,temp的后面
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    public void update(HeroNode newHeroNode){
        if(head.next==null){
        System.out.println("该链表为空");
        }
        HeroNode temp=head.next;
        boolean flag=false;
        while (true) {
            if (temp == null) {
                //链表已经遍历到最后了
                return;
            }
            if(temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        //根据找到的链表节点修改链表节点数据
        if(flag=true){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else{
            System.out.printf("未找到节点%d",newHeroNode.no);
        }
    }
    //显示链表
    public void lis(){
        //首先需要判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
            //因为头结点不能动,所以需要一个辅助变量来遍历
            HeroNode temp = head.next;
            while (true) {
                //判断链表是否到了最后
                if (temp == null) {
                    break;
                }
                    System.out.println(temp);
                    //一定将temp后移
                    temp = temp.next;

            }

    }
}
//定义HeroNode,每一个HeroNode都是一个节点
class HeroNode{
    public int no;//编号
    public String name;//姓名
    public String nickname;//昵称
    public HeroNode next;//指向下一个节点
    // 构造器
    public HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
    }
    //重写toString

    @Override
    public String toString() {
        return "HeroNode=[no="+no+",name="+name+",nickname="+nickname+"]";
    }
}