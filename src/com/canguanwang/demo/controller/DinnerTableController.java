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
 * 餐桌控制
 */
@WebServlet("/tableController")
public class DinnerTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private DinnerTableService dinnerTableService = new DinnerTableServiceImpl();

	public DinnerTableController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  //请求编码utf-8
		response.setContentType("text/html; charset=UTF-8");  //响应内容类型utf-8
		String op = request.getParameter("op");
		switch (op) {
			case "list":
				String tableName = request.getParameter("tableName");
				if (tableName == null) {
					tableName = "";
				}
				List<DinnerTable> dinnerTables = null;
				try {
//					查询餐桌名
					dinnerTables = dinnerTableService.getAllDinnerTables(tableName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//跳转到餐桌页面
				request.setAttribute("dinnerTables", dinnerTables);
				request.getRequestDispatcher("admin/detail/table_list.jsp").forward(request, response);
				break;
			//跳转到添加桌子页面
			case "goto_add":
				request.getRequestDispatcher("admin/detail/table_save.jsp").forward(request, response);
				break;

			//保存餐桌
			case "table_save":
				String tbName = request.getParameter("tableName");
				DinnerTable dinnerTable = new DinnerTable();
				dinnerTable.setTable_name(tbName);
				dinnerTable.setTable_status(0);//默认状态为0
				int res = 0;
				try {
//					新增餐桌名
					res = dinnerTableService.addDinnerTable(dinnerTable);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (res > 0) {
					response.sendRedirect("tableController?op=list");
				} else {
					request.setAttribute("msg", "保存失败");
					request.getRequestDispatcher("admin/detail/table_save.jsp").forward(request, response);
				}
				break;
			//退桌功能
			case "update":
				String tableIdStr = request.getParameter("tableId");
				Integer tableId = Integer.valueOf(tableIdStr);  //返回原生值
				String tableStatus = request.getParameter("tableStatus");
				DinnerTable updateDinnerTb = new DinnerTable();
				updateDinnerTb.setTable_id(tableId);
				updateDinnerTb.setTable_status(Integer.valueOf(tableStatus));
				int update = 0;
				try {
					update = dinnerTableService.updateDinnerTableSelective(updateDinnerTb);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				if (update > 0) {
					request.removeAttribute("msg");
					response.sendRedirect("tableController?op=list");
				} else {
					request.setAttribute("msg", "退桌失败");
					response.sendRedirect("tableController?op=list");
				}
				break;
			//删除餐桌
			case "delete":
				String tbId = request.getParameter("tableId");
				int delete = 0;
				try {
					delete = dinnerTableService.deleteById(Integer.valueOf(tbId));
				} catch (Exception e) {
					e.printStackTrace();
				}
				//删除不为0时，代表删除成功
				if (delete > 0) {
					request.removeAttribute("msg");
					response.sendRedirect("tableController?op=list");
				} else {
					request.setAttribute("msg", "删除失败");
					response.sendRedirect("tableController?op=list");
				}
				break;
			default:
				break;
		}
	}

}
