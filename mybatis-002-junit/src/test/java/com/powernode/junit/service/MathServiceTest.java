package com.powernode.junit.service;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author 杜嘉豪
 * @create 2024/3/28 21:44
 * @description:
 */
public class MathServiceTest {
    private final static MathService mathService = new MathService();

    @Test
    public void testSum() {
        int sub = mathService.sum(2, 3);
        Assert.assertEquals("sum结果不正确", 5, sub);
    }

    @Test
    public void testSub() {
        int sub = mathService.sub(5, 2);
        Assert.assertEquals("sub结果不正确", 3, sub);
    }
}
