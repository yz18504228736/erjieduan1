package com.canguanwang.demo.controller;

import com.canguanwang.demo.bean.Food;
import com.canguanwang.demo.bean.FoodType;
import com.canguanwang.demo.bean.PageBean;
import com.canguanwang.demo.bean.User;
import com.canguanwang.demo.service.FoodService;
import com.canguanwang.demo.service.FoodTypeService;
import com.canguanwang.demo.service.UserService;
import com.canguanwang.demo.service.impl.FoodServiceImpl;
import com.canguanwang.demo.service.impl.FoodTypeServiceImpl;
import com.canguanwang.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 菜品控制
 */
@MultipartConfig
@WebServlet("/foodController")
public class FoodController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();
    private FoodService foodService = new FoodServiceImpl();
    private FoodTypeService foodTypeService = new FoodTypeServiceImpl();

    public FoodController() {
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
                String foodName = request.getParameter("foodName");
                if (foodName == null) {
                    foodName = "";
                }
                List<Food> foods = null;
                List<FoodType> foodTypes = null;
                try {
                    foods = foodService.getAllFoods(foodName);
                    foodTypes = foodTypeService.getAllFoodTypes("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("foods", foods);
                request.setAttribute("types", foodTypes);
                request.getRequestDispatcher("admin/detail/food_list.jsp").forward(request, response);
                break;

            case "goto_add":
                List<FoodType> foodTypeList = null;
                try {
                    foodTypeList = foodTypeService.getAllFoodTypes("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("types", foodTypeList);
                request.getRequestDispatcher("admin/detail/food_save.jsp").forward(request, response);
                break;

            case "food_save":
                //上传图片
                Part part = request.getPart("imageUrl");
                String foodImg = null;
                //判断有没有图片，如果有就上传，没有就不传
                if (part != null) {
                    String realPath = getServletContext().getRealPath("/upload");
                    String fileName = UUID.randomUUID().toString();
                    String cd = part.getHeader("Content-Disposition");
                    String[] split = cd.split(";");
                    String fileNameStr = split[2];
                    String[] splitFileName = fileNameStr.split("=");
                    String fileN = splitFileName[1];
                    if (!"\"\"".equals(fileN)) {
                        String suffix = cd.substring(cd.lastIndexOf('.'), cd.length() - 1);
                        File file = new File(realPath + "/" + fileName + suffix);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        part.write(realPath + "/" + fileName + suffix);
                        System.out.println(realPath + "/" + fileName + suffix);

                        foodImg = "upload/" + fileName + suffix;
                    }
                }
                String fodName = request.getParameter("foodName");
                String tyIdStr = request.getParameter("typeId");
                String fodIdStr = request.getParameter("foodId");
                String foodDesc = request.getParameter("foodDesc");
                String foodPrice = request.getParameter("foodPrice");
                String foodMPrice = request.getParameter("foodMPrice");
                List<FoodType> foodTypeLists = null;
                try {
                    foodTypeLists = foodTypeService.getAllFoodTypes("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (fodName == null || "".equals(fodName)) {
                    request.setAttribute("types", foodTypeLists);
                    request.setAttribute("msg", "菜品名不能为空");
                    request.getRequestDispatcher("admin/detail/food_save.jsp").forward(request, response);
                }
                if (tyIdStr == null || "".equals(tyIdStr)) {
                    request.setAttribute("types", foodTypeLists);
                    request.setAttribute("msg", "菜系不能为空");
                    request.getRequestDispatcher("admin/detail/food_save.jsp").forward(request, response);
                }
                if (foodPrice == null || "".equals(foodPrice)) {
                    request.setAttribute("types", foodTypeLists);
                    request.setAttribute("msg", "价格不能为空");
                    request.getRequestDispatcher("admin/detail/food_save.jsp").forward(request, response);
                }
                if (foodMPrice == null || "".equals(foodMPrice)) {
                    request.setAttribute("types", foodTypeLists);
                    request.setAttribute("msg", "会员价格不能为空");
                    request.getRequestDispatcher("admin/detail/food_save.jsp").forward(request, response);
                }
                Food food = new Food();
                food.setType_id(Integer.valueOf(tyIdStr));
                food.setFood_name(fodName);
                food.setFood_image(foodImg);
                food.setFood_desc(foodDesc);
                food.setFood_price(BigDecimal.valueOf(Double.valueOf(foodPrice)));
                food.setFood_mprice(BigDecimal.valueOf(Double.valueOf(foodMPrice)));
                if (fodIdStr != null && !"".equals(fodIdStr)) {
                    food.setFood_id(Integer.valueOf(fodIdStr));
                }
                int res = 0;
                try {
                    if (food.getFood_id() == null) {
                        res = foodService.addFood(food);
                    } else {
                        res = foodService.updateFoodSelective(food);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (res > 0) {
                    response.sendRedirect("foodController?op=list");
                } else {
                    request.setAttribute("types", foodTypeLists);
                    request.setAttribute("msg", "保存失败");
                    request.getRequestDispatcher("admin/detail/food_save.jsp").forward(request, response);
                }
                break;

            case "goto_update":
                String foodIdStr = request.getParameter("foodId");
                Integer foodId = Integer.valueOf(foodIdStr);
                try {
                    Food foodRes = foodService.getFoodById(foodId);
                    if (foodRes != null) {
                        request.setAttribute("food", foodRes);
                        List<FoodType> allFoodTypes = foodTypeService.getAllFoodTypes("");
                        request.setAttribute("types", allFoodTypes);
                        request.getRequestDispatcher("admin/detail/food_save.jsp").forward(request, response);
                    } else {
                        request.setAttribute("msg", "跳转更新页面错误");
                        response.sendRedirect("foodController?op=list");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case "delete":
                String fdId = request.getParameter("foodId");
                int delete = 0;
                try {
                    delete = foodService.deleteById(Integer.valueOf(fdId));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (delete > 0) {
                    request.removeAttribute("msg");
                    response.sendRedirect("foodController?op=list");
                } else {
                    request.setAttribute("msg", "删除失败");
                    response.sendRedirect("foodController?op=list");
                }
                break;

            case "page_list":
                String pageNumStr = request.getParameter("pageNum");
                String foodNameStr = request.getParameter("foodName");
                int pageNum = Integer.valueOf(pageNumStr);
                String foodType = request.getParameter("typeId");
                String tableId = request.getParameter("tableId");
                Integer typeIdd = null;
                if (foodType != null && !"".equals(foodType)) {
                    typeIdd = Integer.valueOf(foodType);
                }
                List<Food> foodList = null;
                long count = 0;
                List<FoodType> foodTypes1 = null;
                try {
                    foodList = foodService.getFoodByPage(pageNum, typeIdd, foodNameStr);
                    count = foodService.getFoodCount(typeIdd, foodNameStr);
                    foodTypes1 = foodTypeService.getAllFoodTypes("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                PageBean<Food> pageBean = new PageBean<>();
                pageBean.setPageNum(pageNum);
                pageBean.setTotalRecords((int) count);
                pageBean.setPageDatas(foodList);
                request.setAttribute("allFoods", pageBean);
                request.setAttribute("tableId", tableId);
                request.setAttribute("allTypes", foodTypes1);
                if (typeIdd != null) {
                    request.setAttribute("typeId", typeIdd);
                }
                request.getRequestDispatcher("front/caidan.jsp").forward(request, response);
                break;
            case "food_detail":
                String foodType1 = request.getParameter("typeId");
                String tableId1 = request.getParameter("tableId");
                String foodId1 = request.getParameter("foodId");
                Integer integer = Integer.valueOf(foodId1);
                Food foodById = null;
                List<FoodType> foodTypes2 = null;
                try {
                    foodById = foodService.getFoodById(integer);
                    foodTypes2 = foodTypeService.getAllFoodTypes("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                request.setAttribute("food", foodById);
                request.setAttribute("tableId", tableId1);
                request.setAttribute("allTypes", foodTypes2);
                if (foodType1 != null) {
                    request.setAttribute("typeId", foodType1);
                }
                request.getRequestDispatcher("front/detail.jsp").forward(request, response);
                break;
            case "cart":
                String foodId2 = request.getParameter("foodId");
                String tableId2 = request.getParameter("tableId");
                String foodType2 = request.getParameter("typeId");
                Food byId = null;
                List<FoodType> foodTypes3 = null;
                try {
                    byId = foodService.getFoodById(Integer.valueOf(foodId2));
                    foodTypes3 = foodTypeService.getAllFoodTypes("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                User user = (User) request.getSession().getAttribute("user");
                Map<Integer, Map<String, Object>> cart = (Map<Integer, Map<String, Object>>) request.getSession().getAttribute("cart");
                if (cart == null) {
                    cart = new HashMap<>();
                }
                if (cart.containsKey(byId.getFood_id())) {
                    int countNum = (int) cart.get(byId.getFood_id()).get("num") + 1;
                    Map<String, Object> detailMap = new HashMap<>();
                    detailMap.put("num", countNum);
                    detailMap.put("price", user.getIs_member() == 1 ? byId.getFood_mprice() : byId.getFood_price());
                    detailMap.put("name", byId.getFood_name());
                    cart.put(byId.getFood_id(), detailMap);
                } else {
                    Map<String, Object> detailMap = new HashMap<>();
                    detailMap.put("num", 1);
                    detailMap.put("price", user.getIs_member() == 1 ? byId.getFood_mprice() : byId.getFood_price());
                    detailMap.put("name", byId.getFood_name());
                    cart.put(byId.getFood_id(), detailMap);
                }
                BigDecimal total = new BigDecimal(0);

                for (Integer byFoodId : cart.keySet()) {
                    BigDecimal price = new BigDecimal(String.valueOf(cart.get(byFoodId).get("price")));
                    BigDecimal num = new BigDecimal(String.valueOf(cart.get(byFoodId).get("num")));
                    BigDecimal multiply = price.multiply(num);
                    total = total.add(multiply);
                }
                request.getSession().setAttribute("cart", cart);
                request.setAttribute("tableId", tableId2);
                request.setAttribute("totalMoney", total);
                request.setAttribute("allTypes", foodTypes3);
                if (foodType2 != null) {
                    request.setAttribute("typeId", foodType2);
                }
                request.getRequestDispatcher("front/cart.jsp").forward(request, response);
                break;
            case "remove_cart":
                removeCart(request, response);
                break;
            case "change_cart":
                changeCart(request, response);
                break;
            default:
                break;
        }
    }

    private void changeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodId2 = request.getParameter("foodId");
        String tableId2 = request.getParameter("tableId");
        String foodType2 = request.getParameter("typeId");
        String numStr = request.getParameter("num");
        Food byId = null;
        List<FoodType> foodTypes3 = null;
        try {
            byId = foodService.getFoodById(Integer.valueOf(foodId2));
            foodTypes3 = foodTypeService.getAllFoodTypes("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        Map<Integer, Map<String, Object>> cart = (Map<Integer, Map<String, Object>>) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        if (cart.containsKey(byId.getFood_id())) {
            int countNum = Integer.valueOf(numStr);
            Map<String, Object> detailMap = new HashMap<>();
            detailMap.put("num", countNum);
            detailMap.put("price", user.getIs_member() == 1 ? byId.getFood_mprice() : byId.getFood_price());
            detailMap.put("name", byId.getFood_name());
            cart.put(byId.getFood_id(), detailMap);
        } else {
            Map<String, Object> detailMap = new HashMap<>();
            detailMap.put("num", Integer.valueOf(numStr));
            detailMap.put("price", user.getIs_member() == 1 ? byId.getFood_mprice() : byId.getFood_price());
            detailMap.put("name", byId.getFood_name());
            cart.put(byId.getFood_id(), detailMap);
        }
        BigDecimal total = new BigDecimal(0);

        for (Integer byFoodId : cart.keySet()) {
            BigDecimal price = new BigDecimal(String.valueOf(cart.get(byFoodId).get("price")));
            BigDecimal num = new BigDecimal(String.valueOf(cart.get(byFoodId).get("num")));
            BigDecimal multiply = price.multiply(num);
            total = total.add(multiply);
        }
        request.getSession().setAttribute("cart", cart);
        request.setAttribute("tableId", tableId2);
        request.setAttribute("totalMoney", total);
        request.setAttribute("allTypes", foodTypes3);
        if (foodType2 != null) {
            request.setAttribute("typeId", foodType2);
        }
        request.getRequestDispatcher("front/cart.jsp").forward(request, response);
    }

    private void removeCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodId2 = request.getParameter("foodId");
        String tableId2 = request.getParameter("tableId");
        String foodType2 = request.getParameter("typeId");
        Food byId = null;
        List<FoodType> foodTypes3 = null;
        try {
            byId = foodService.getFoodById(Integer.valueOf(foodId2));
            foodTypes3 = foodTypeService.getAllFoodTypes("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = (User) request.getSession().getAttribute("user");
        Map<Integer, Map<String, Object>> cart = (Map<Integer, Map<String, Object>>) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        } else {
            cart.remove(Integer.valueOf(foodId2));
        }

        BigDecimal total = new BigDecimal(0);

        for (Integer byFoodId : cart.keySet()) {
            BigDecimal price = new BigDecimal(String.valueOf(cart.get(byFoodId).get("price")));
            BigDecimal num = new BigDecimal(String.valueOf(cart.get(byFoodId).get("num")));
            BigDecimal multiply = price.multiply(num);
            total = total.add(multiply);
        }
        request.getSession().setAttribute("cart", cart);
        request.setAttribute("tableId", tableId2);
        request.setAttribute("totalMoney", total);
        request.setAttribute("allTypes", foodTypes3);
        if (foodType2 != null) {
            request.setAttribute("typeId", foodType2);
        }
        request.getRequestDispatcher("front/cart.jsp").forward(request, response);
    }

}
