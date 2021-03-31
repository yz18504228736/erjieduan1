package com.canguanwang.demo.controller;

import com.canguanwang.demo.bean.Food;
import com.canguanwang.demo.bean.FoodType;
import com.canguanwang.demo.service.FoodTypeService;
import com.canguanwang.demo.service.UserService;
import com.canguanwang.demo.service.impl.FoodTypeServiceImpl;
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
 * 菜系控制
 */
@WebServlet("/typeController")
public class FoodTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private FoodTypeService foodTypeService = new FoodTypeServiceImpl();

	public FoodTypeController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String op = request.getParameter("op");
		switch (op) {
			case "list":
				String typeName = request.getParameter("typeName");
				if (typeName == null) {
					typeName = "";
				}
				List<FoodType> foodTypes = null;
				try {
					foodTypes = foodTypeService.getAllFoodTypes(typeName);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("foodTypes", foodTypes);
				request.getRequestDispatcher("admin/detail/food_type_list.jsp").forward(request, response);
				break;
			case "goto_add":
				request.getRequestDispatcher("admin/detail/food_type_save.jsp").forward(request, response);
				break;
			case "type_save":
				String tyName = request.getParameter("typeName");
				String tyIdStr = request.getParameter("typeId");
				FoodType foodType = new FoodType();
				foodType.setType_name(tyName);
				if (tyIdStr != null && !"".equals(tyIdStr)) {
					foodType.setType_id(Integer.valueOf(tyIdStr));
				}
				int res = 0;
				try {
					if (foodType.getType_id() == null) {
						res = foodTypeService.addFoodType(foodType);
					} else {
						res = foodTypeService.updateFoodTypeSelective(foodType);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (res > 0) {
					response.sendRedirect("typeController?op=list");
				} else {
					request.setAttribute("msg", "保存失败");
					request.getRequestDispatcher("admin/detail/food_type_save.jsp").forward(request, response);
				}
				break;
			case "goto_update":
				String typeIdStr = request.getParameter("typeId");
				Integer typeId = Integer.valueOf(typeIdStr);
				FoodType foodTypeRes = null;
				try {
					foodTypeRes = foodTypeService.getFoodTypeById(typeId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (foodTypeRes != null) {
					request.setAttribute("type", foodTypeRes);
					request.getRequestDispatcher("admin/detail/food_type_save.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "进入编辑页面失败");
					response.sendRedirect("typeController?op=list");
				}
				break;
			case "delete":
				String tyId = request.getParameter("typeId");
				int delete = 0;
				try {
					delete = foodTypeService.deleteById(Integer.valueOf(tyId));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (delete > 0) {
					request.removeAttribute("msg");
					response.sendRedirect("typeController?op=list");
				} else {
					request.setAttribute("msg", "删除失败");
					response.sendRedirect("typeController?op=list");
				}
				break;
			default:
				break;
		}
	}

}
