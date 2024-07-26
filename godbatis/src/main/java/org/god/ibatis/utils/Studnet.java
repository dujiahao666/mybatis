package org.god.ibatis.utils;

/**
 * @author 杜嘉豪
 * @create 2024/4/18 16:16
 * @description:
 */
public class Studnet {
    private String name;
    private int age;

    public Studnet() {
    }

    public Studnet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Studnet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
