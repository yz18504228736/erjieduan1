package com.canguanwang.demo.controller;

import com.canguanwang.demo.bean.User;
import com.canguanwang.demo.service.UserService;
import com.canguanwang.demo.service.impl.UserServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制
 */

@WebServlet("/adminController")
public class AdminController extends HttpServlet {
	private UserService userService = new UserServiceImpl();

	public AdminController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");

		/**
		 * 判断用户名和密码，且不为空
		 */


		switch (op) {
			case "login":
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				User user = null;
				try {
					user = userService.getUserByNameAndPwd(name, password);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (user != null) {
					Integer isAdmin = user.getIs_admin();
					if (isAdmin == 1) {
						//如果满足条件向前台admin/index.jsp发送请求
						request.getSession().setAttribute("admin", user);
						request.getRequestDispatcher("admin/index.jsp").forward(request, response);
					} else {
						//不满足条件提示后转到admin/login.jsp
						request.setAttribute("login", "您不是管理员身份");
						request.getRequestDispatcher("admin/login.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("login", "登录名或密码输入错误");
					request.getRequestDispatcher("admin/login.jsp").forward(request, response);
				}
				break;
			//后台退出按钮
			//清除session并退出
			case "logout":
				request.getSession().removeAttribute("admin");
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
				break;
			case "index":
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);
			default:
				break;
		}
	}

}
