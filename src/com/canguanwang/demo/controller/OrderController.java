package com.canguanwang.demo.controller;

import com.canguanwang.demo.bean.*;
import com.canguanwang.demo.service.DinnerTableService;
import com.canguanwang.demo.service.FoodTypeService;
import com.canguanwang.demo.service.OrderService;
import com.canguanwang.demo.service.UserService;
import com.canguanwang.demo.service.impl.DinnerTableServiceImpl;
import com.canguanwang.demo.service.impl.FoodTypeServiceImpl;
import com.canguanwang.demo.service.impl.OrderServiceImpl;
import com.canguanwang.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * 订单控制
 */
@WebServlet("/orderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private DinnerTableService dinnerTableService = new DinnerTableServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private FoodTypeService foodTypeService = new FoodTypeServiceImpl();

	public OrderController() {
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
				String tableName = request.getParameter("orderName");
				if (tableName == null) {
					tableName = "";
				}
				List<Order> orders = null;
				List<DinnerTable> tableList = null;
				try {
					orders = orderService.getAllOrders(tableName);
					tableList = dinnerTableService.getAllDinnerTables("");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("orderList", orders);
				request.setAttribute("tableList", tableList);
				request.getRequestDispatcher("admin/detail/order_list.jsp").forward(request, response);
				break;
			case "order_detail":

				break;
			case "update":
				String orderId = request.getParameter("orderId");
				String tableStatus = request.getParameter("orderStauts");
				Order order = new Order();
				order.setOrder_id(orderId);
				order.setOrder_status(Integer.valueOf(tableStatus));
				int update = 0;
				try {
					update = orderService.updateOrderSelective(order);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (update > 0) {
					request.removeAttribute("msg");
					response.sendRedirect("orderController?op=list");
				} else {
					request.setAttribute("msg", "结账失败");
					response.sendRedirect("orderController?op=list");
				}
				break;
			case "delete":
				String odId = request.getParameter("orderId");
				int delete = 0;
				try {
					delete = orderService.deleteById(odId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (delete > 0) {
					request.removeAttribute("msg");
					response.sendRedirect("orderController?op=list");
				} else {
					request.setAttribute("msg", "删除失败");
					response.sendRedirect("orderController?op=list");
				}
				break;
			case "save_order":
				String tableId2 = request.getParameter("tableId");
				String foodType2 = request.getParameter("typeId");
				List<FoodType> foodTypes3 = null;
				try {
					foodTypes3 = foodTypeService.getAllFoodTypes("");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				User user = (User) request.getSession().getAttribute("user");
				Map<Integer, Map<String, Object>> cart = (Map<Integer, Map<String, Object>>) request.getSession().getAttribute("cart");
				if (cart == null) {
					cart = new HashMap<>();
				}
				int totalNums = 0;
				BigDecimal total = new BigDecimal(0);
				for (Integer byFoodId : cart.keySet()) {
					totalNums += Integer.valueOf((Integer) cart.get(byFoodId).get("num"));
					BigDecimal price = new BigDecimal(String.valueOf(cart.get(byFoodId).get("price")));
					BigDecimal num = new BigDecimal(String.valueOf(cart.get(byFoodId).get("num")));
					BigDecimal multiply = price.multiply(num);
					total = total.add(multiply);

				}
				Order orderSave = new Order();
				orderSave.setOrder_id(UUID.randomUUID().toString().replace("-","").substring(0, 14));
				orderSave.setOrder_status(1);
				orderSave.setOrder_create_time(new Date());
				orderSave.setTable_id(Integer.valueOf(tableId2));
				orderSave.setTotal_num(totalNums);
				orderSave.setOrder_total_price(total);
				orderSave.setUser_id(user.getUser_id());
				if (totalNums > 0) {
					try {
						orderService.addOrder(orderSave);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				request.getSession().setAttribute("cart", cart);
				request.setAttribute("tableId", tableId2);
				request.setAttribute("totalMoney", total);
				request.setAttribute("allTypes", foodTypes3);
				if (foodType2 != null) {
					request.setAttribute("typeId", foodType2);
				}
				request.getRequestDispatcher("front/order_list.jsp").forward(request, response);
				break;
			default:
				break;
		}
	}

}
