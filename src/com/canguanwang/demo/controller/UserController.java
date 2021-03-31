package com.canguanwang.demo.controller;

import com.canguanwang.demo.bean.DinnerTable;
import com.canguanwang.demo.bean.User;
import com.canguanwang.demo.service.DinnerTableService;
import com.canguanwang.demo.service.UserService;
import com.canguanwang.demo.service.impl.DinnerTableServiceImpl;
import com.canguanwang.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 用户控制
 */
@WebServlet("/userController")
public class UserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private DinnerTableService dinnerTableService = new DinnerTableServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "login":
                String name = request.getParameter("username");
                String password = request.getParameter("password");
                User user = null;
                try {
                    user = userService.getUserByNameAndPwd(name, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    List<DinnerTable> dinnerTableList = null;
                    try {
                        dinnerTableList = dinnerTableService.getEmptyDinnerTables();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    request.getSession().setAttribute("dinnerTableList", dinnerTableList);
                    request.getRequestDispatcher("front/index.jsp").forward(request, response);
                } else {
                    request.setAttribute("login", "登录名或密码输入错误");
                    request.getRequestDispatcher("front/login.jsp").forward(request, response);
                }
                break;
            case "logout":
                request.getSession().removeAttribute("admin");
                request.getRequestDispatcher("front/login.jsp").forward(request, response);
                break;
            case "index":
                List<DinnerTable> dinnerTableList1 = null;
                try {
                    dinnerTableList1 = dinnerTableService.getEmptyDinnerTables();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.getSession().setAttribute("dinnerTableList", dinnerTableList1);
                request.getRequestDispatcher("front/index.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }
}
