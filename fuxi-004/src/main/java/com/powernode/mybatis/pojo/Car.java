package com.powernode.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/4 14:51
 * @description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;
}
