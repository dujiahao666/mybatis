package com.powernode.bank.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 11:51
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account {
    private Long id;
    private String actno;
    private Double balance;
}
