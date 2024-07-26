package org.god.ibatis.utils;

import java.io.InputStream;

/**
 * @author 杜嘉豪
 * @create 2024/4/16 20:58
 * @description: godbatis框架提供的一个工具类
 *               这个工具类专门完成“类路径”中资源的加载
 */
public class Resources {

    //私有化构造方法
    private Resources(){}

    /**
     * 从类路径中加载资源
     * @param resource  放在类路径当中的资源文件
     * @return 指向资源文件的一个输入流
     */
    public static InputStream getResourceAsStream(String resource){
        return ClassLoader.getSystemClassLoader().getResourceAsStream(resource);
    }
}
