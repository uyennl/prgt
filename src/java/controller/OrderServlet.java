/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.dao.DishDAO;
import model.dao.OrderDAO;
import model.entity.Customer;
import model.entity.Dish;
import model.entity.Order;

/**
 *
 * @author PC
 */
public class OrderServlet extends HttpServlet {

    private OrderDAO orderDAO = new OrderDAO();
    private DishDAO dishDAO = new DishDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        switch (url) {
            case "/addOrder":
                showOrder(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);

        switch (url) {
            case "/addOrder":
                orderDish(request, response);
                break;
            default:
                break;
        }
    }

    private void showOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("order"); 
        HttpSession sessionAccount = request.getSession();
        if(sessionAccount != null && sessionAccount.getAttribute("seeUser") != null){
            Customer cus = (Customer) session.getAttribute("seeUser");
            System.out.println(cus.toString());
            request.setAttribute("seeId", cus.getIdCustomer());
        }
        ArrayList<Dish> dishList = dishDAO.selectAll();
        request.setAttribute("dishList", dishList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("orderDish.jsp");
        dispatcher.forward(request, response);
    }

    private void orderDish(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> orderList = new ArrayList<>();
        HttpSession session = request.getSession();
        int customerID = Integer.parseInt((String) session.getAttribute("seeId"));
        System.out.println(customerID);
        Customer customer = new Customer();
        customer.setIdCustomer(customerID);
        java.util.Date currentDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        Order order = new Order(sqlDate,customer);
        orderList.add(order);
        System.out.println(order);
        orderDAO.insert(order);
        response.sendRedirect(request.getContextPath() + "/addOrder");
    }
    
//    private void
}
