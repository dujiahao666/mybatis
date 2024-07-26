package org.god.ibatis.utils;

/**
 * @author 杜嘉豪
 * @create 2024/4/17 1:14
 * @description:
 */
public class Gongju {
    public Gongju() {
    }

    private int index=1;
    private String name ="";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public void show(){
//        System.out.println(name+"出来了");
//    }
    public void show(){
        if (index==0){
            System.out.print("嘉嘉");
            this.name="";
            index--;
        }
//        System.out.println(name+"出来了");
        if(index==1){
            this.name="嘉嘉";
            index--;
        }
        System.out.println("出来了");
    }

    public void jia(){
        this.name="嘉嘉";
    }
}








class s{
    public static void main(String[] args) {
        Gongju dd=new Gongju();
        dd.show();
        System.out.println("==========");
        dd.show();
        System.out.println("============");
        dd.show();
        dd.show();
        dd.show();
        dd.show();
    }
}
