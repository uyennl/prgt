/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.dao.OrderDAO;
import model.dao.OrderDetailsDAO;
import model.entity.OrderDetails;

/**
 *
 * @author PC
 */
public class OrderDetailsServlet extends HttpServlet {

    private OrderDAO orderDAO = new OrderDAO();
    private OrderDetailsDAO odDAO = new OrderDetailsDAO(); 
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
            out.println("<title>Servlet OrderDetails</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderDetails at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/orderDetails":
                orderDetail(request, response);
                break;
            default:
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
        System.out.println(url);
        switch (url) {
            case "/orderDetails":
                orderDetail(request, response);
                break;
            default:
                break;
        }
    }

    private void showBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<OrderDetails> odList = odDAO.selectAll();
        
    }

    private void orderDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idDish = Integer.parseInt(request.getParameter("idDish"));
        System.out.println(idDish);
//        String typePayment = request.getParameter("typePayment");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        int orderId
    }

}
