package com.powernode.bank.web;

import com.powernode.bank.exceptions.MoneyNotEnoughException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * @author 杜嘉豪
 * @create 2024/4/5 15:37
 * @description:
 */
//@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {
    //为了让这个对象在其他方法中也可以调用，声明为实例变量
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        String moneyend = request.getParameter("money");
        double money = Double.parseDouble(moneyend);

        try {
            //调用service的转账方法完成转账(调用业务层)
            accountService.transfer(fromActno, toActno, money);
            //程序能走到这里，表示转账一定成功了
            //调用view展示结果
            response.sendRedirect(request.getContextPath()+"/success.html");
        } catch (MoneyNotEnoughException e) {
            response.sendRedirect(request.getContextPath()+"/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath()+"/error2.html");
        }catch (Exception e){
            response.sendRedirect(request.getContextPath()+"/error2.html");
        }

        //调用view视图层展示数据

    }
}
