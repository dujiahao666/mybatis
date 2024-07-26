package com.powernode.javassist;

import com.pw.as.AccountDaoha;
import com.pw.as.Love;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 杜嘉豪
 * @create 2024/4/6 20:47
 * @description:
 */
public class JavassistTestTwo {

    @Test
    public void testLei() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.jiajia.Ta1");
        String method = "public void ce(){System.out.println(\"真好啊\");}";
        CtMethod ctMethod = CtMethod.make(method, ctClass);
        ctClass.addMethod(ctMethod);
        Class<?> aClass = ctClass.toClass();
        Object obj = aClass.newInstance();
        Method declaredMethod = aClass.getDeclaredMethod("ce");
        declaredMethod.invoke(obj);
    }

    @Test
    public void testLove() throws CannotCompileException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.jiajia.Ta1");
        CtClass ctClass1 = pool.makeInterface("com.pw.as.Love");
        ctClass.addInterface(ctClass1);
        String method = "public void start(){System.out.println(\"爱情的起点\");}";
        String method2 = "public void end(){System.out.println(\"爱情的终点\");}";
        CtMethod ctMethod1 = CtMethod.make(method, ctClass);
        CtMethod ctMethod2 = CtMethod.make(method2, ctClass);
        ctClass.addMethod(ctMethod1);
        ctClass.addMethod(ctMethod2);
        Class<?> aClass = ctClass.toClass();
        Love love = (Love) aClass.newInstance();
      /*  Method declaredMethod = aClass.getDeclaredMethod("start");
        Method declaredMethod1 = aClass.getDeclaredMethod("end");
        declaredMethod.invoke(love);*/
        love.start();
        love.end();
    }

    @Test
    public void testGenetateAccountDaohaImpl() throws CannotCompileException, InstantiationException, IllegalAccessException {
        //获取类池
        ClassPool pool = ClassPool.getDefault();
        //制造类
        CtClass ctClass = pool.makeClass("com.jiajai/AccountDaohaImpl");
        //制造接口
        CtClass ctInterface = pool.makeInterface("com.pw.as.AccountDaoha");
        //实现接口
        ctClass.addInterface(ctInterface);
        //实现接口中所有方法
        //获取接口中所有的方法
        Method[] methods = AccountDaoha.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(method -> {
            try {
                StringBuilder methodCode = new StringBuilder();
                methodCode.append("public "); //追加修饰符列表
                methodCode.append(method.getReturnType().getName()); //追加返回值类型
                methodCode.append(" ");
                methodCode.append(method.getName()); //追加方法名
                methodCode.append("(");
                //拼接参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    Class<?> parameterType = parameterTypes[i];
                    methodCode.append(parameterType.getName());
                    methodCode.append(" ");
                    methodCode.append("arg"+i);
                    if(i!=parameterTypes.length-1){
                        methodCode.append(",");
                    }
                }
                methodCode.append("){System.out.println(111111);");
                String simpleName = method.getReturnType().getSimpleName();
                if("void".equals(simpleName)){

                }else if("int".equals(simpleName)){
                    methodCode.append("return 1;");
                }else if("String".equals(simpleName)){
                    methodCode.append("return \"hello\";");
                }
                methodCode.append("}");
                System.out.println(methodCode);
                CtMethod ctMethod = CtMethod.make(methodCode.toString(), ctClass);
                ctClass.addMethod(ctMethod);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //在内存中生成class,并加载到JVM当中
        Class<?> aClass = ctClass.toClass();
        
        //创建对象
        AccountDaoha accountDaoha = (AccountDaoha)aClass.newInstance();
        //调用方法
        accountDaoha.delete();
        accountDaoha.insert("45");
        accountDaoha.update("aa",89.8);
        accountDaoha.selectByActno("aa");

    }
}
