package org.god.ibatis.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 杜嘉豪
 * @create 2024/4/18 16:17
 * @description:
 */
public class Fs {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("org.god.ibatis.utils.Studnet");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Object  pojo= declaredConstructor.newInstance();
        Method setName = aClass.getDeclaredMethod("setName", String.class);
        setName.setAccessible(true);
        Object invoke = setName.invoke(pojo, "嘉嘉");
        Method setAge = aClass.getDeclaredMethod("setAge", int.class);
        setAge.setAccessible(true);
        setAge.invoke(pojo,21);
        System.out.println(pojo);
    }
}
