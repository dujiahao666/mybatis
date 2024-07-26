package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 杜嘉豪
 * @create 2024/4/14 22:20
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
    private Integer cid;
    private String cname;
    private List<Student> stus;
}
