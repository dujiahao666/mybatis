package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/4/23 0:41
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer id;
    private String carNum;
    private String brand;
    private double guidePrice;
    private String produceTime;
    private String carType;
}
