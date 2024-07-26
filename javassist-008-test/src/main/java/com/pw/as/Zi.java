package com.pw.as;

/**
 * @author 杜嘉豪
 * @create 2024/4/6 21:32
 * @description:
 */
public class Zi implements Fu{
    @Override
    public void st() {
        System.out.println("开始");
    }

    @Override
    public void en() {
        System.out.println("结束");
        System.out.println(Fu.class.getName());
    }
}


class  ds{
    public static void main(String[] args) {
        Zi s=new Zi();
        s.en();
    }
}
