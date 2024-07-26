package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杜嘉豪
 * @create 2024/4/9 17:13
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer id;
    private String log;
    private String time;
}
