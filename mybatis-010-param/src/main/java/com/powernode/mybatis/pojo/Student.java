package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 杜嘉豪
 * @create 2024/4/11 11:37
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Date birth;
    private Character sex;
}
