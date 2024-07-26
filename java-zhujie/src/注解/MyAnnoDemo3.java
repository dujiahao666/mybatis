package 注解;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 杜嘉豪
 * @create 2024/3/29 11:28
 * @description:
 */
public class MyAnnoDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("注解.MyTestDemo");   //这里是全类名
        MyTestDemo mtd=new MyTestDemo();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            //判断当前方法上面有没有MyTest注解
            if(method.isAnnotationPresent(MyTest.class));
                method.invoke(mtd);
        }


    }
}
