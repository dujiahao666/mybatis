package com.powernode.javassist;

import  com.pw.as.AccountDaoha;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;




public class JavassistTest {
    @Test
    public void testGenerateFristClass() throws CannotCompileException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        //获取类池，这个类池就是用来给我们生成class的
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.powernode.bank.dao.impl.AccountDaoImplba");
        String methodCode = "public void insert(){ System.out.println(123);}";
        //制造方法
        CtMethod ctMethod = CtMethod.make(methodCode, ctClass);
        //将方法添加到类中
        ctClass.addMethod(ctMethod);
        //在内存中生成class
        ctClass.toClass();


        Class<?> clazz= Class.forName("com.powernode.bank.dao.impl.AccountDaoImplba");
        Object obj = clazz.newInstance();
        Method declaredMethod = clazz.getDeclaredMethod("insert");
        declaredMethod.invoke(obj);
    }

    @Test
    public void testGenetateImpl() throws Exception{
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.p2.as.AccountImpl");
        //制造接口
        CtClass ctInterface = pool.makeInterface("com.pw.as.AccountDaoha");
        //添加接口到类中
        ctClass.addInterface(ctInterface);
        //实现接口中的方法
        //制造方法
        CtMethod ctMethod = CtMethod.make("public void delete(){System.out.println(\"你好\");}", ctClass);
        //将方法添加到类中
        ctClass.addMethod(ctMethod);
        //内存中生成类，同时将生成的类加载到JVM中
        Class<?> aClass = ctClass.toClass();
        AccountDaoha accountDao =(AccountDaoha) aClass.newInstance();
        accountDao.delete();
        /*Object o = aClass.newInstance();
        Method declaredMethod = aClass.getDeclaredMethod("delete");
        declaredMethod.invoke(o);*/

    }

}
