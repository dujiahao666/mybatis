package 注解;

/**
 * @author 杜嘉豪
 * @create 2024/3/29 11:27
 * @description:
 */
public class MyTestDemo {
    @MyTest
    public void method(){
        System.out.println("这是方法一");
    }
    @MyTest
    public void method2(){
        System.out.println("这是方法二");
    }
    public void method3(){

    }
}
