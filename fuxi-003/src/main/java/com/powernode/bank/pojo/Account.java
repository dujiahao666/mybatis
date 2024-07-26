package com.powernode.bank.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/3 22:39
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String actno;
    private Double balance;
}
