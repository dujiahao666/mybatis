package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杜嘉豪
 * @create 2024/4/14 22:19
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer sid;
    private String sname;
    private Clazz clazz;
//    private Integer cid;
}
