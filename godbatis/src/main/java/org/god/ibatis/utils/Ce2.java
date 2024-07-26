package org.god.ibatis.utils;

/**
 * @author 杜嘉豪
 * @create 2024/4/17 21:49
 * @description:
 */
public class Ce2 {
    int index = 1;
    /*public void show(){
        if(index==0){
            System.out.print("嘉嘉");
            index--;
        }
        if(index==1){
            index--;
        }
        System.out.println("出来了");
    }*/

    public void show() {
        if (index == 2) {
            System.out.print("嘉嘉");
            index++;
        }
        if (index == 1) {
            index++;
        }
        System.out.println("出来了");
    }
}


class AS2 {
    public static void main(String[] args) {
        Ce2 ce2 = new Ce2();
        ce2.show();
        ce2.show();
        ce2.show();
        ce2.show();
        ce2.show();
        ce2.show();
        ce2.show();
    }
}


class sd {
    public static void main(String[] args) {
        System.out.println(12345 / 10);
    }
}


class AS3 {
    public static void main(String[] args) {
        String str = "asDAs";
        System.out.println(str);
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
    }
}

class as4 {
    public static void main(String[] args) {
        int i = 10;
        int j = 3;
        int count = 0;
        while (i > j) {
            i = i - j;
            count=count+1;
        }
        System.out.println("商是："+count);
        System.out.println("余数是："+i);
    }
}


