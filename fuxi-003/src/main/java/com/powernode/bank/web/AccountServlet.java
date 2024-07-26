package com.powernode.bank.web;

import com.powernode.bank.exceptions.MoneyNotEnougthException;
import com.powernode.bank.exceptions.TransferException;
import com.powernode.bank.service.AccountService;
import com.powernode.bank.service.Impl.AccountServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/3 22:46
 * @description:
 */

public class AccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fromActno = request.getParameter("fromActno");
        String toActno = request.getParameter("toActno");
        double money = Double.parseDouble(request.getParameter("money"));
        //调用service的转账方法完成转账。（调业务层）
        AccountService accountService=new AccountServiceImpl();
        try {
            //调用service的转账方法完成转账(调用业务层)
            accountService.transfer(fromActno, toActno, money);
            //程序能走到这里，表示转账一定成功了
            //调用view展示结果
            response.sendRedirect(request.getContextPath()+"/success.html");
        } catch (MoneyNotEnougthException e) {
            response.sendRedirect(request.getContextPath()+"/error1.html");
        } catch (TransferException e) {
            response.sendRedirect(request.getContextPath()+"/error2.html");
        }catch (Exception e){
            response.sendRedirect(request.getContextPath()+"/error2.html");
        }
    }
}
