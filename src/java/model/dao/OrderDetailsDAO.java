/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import model.database.ConnectDB;
import model.entity.OrderDetails;
import java.sql.*;
import model.entity.Dish;
import model.entity.Order;
import model.utils.MyQuery;

/**
 *
 * @author PC
 */
public class OrderDetailsDAO implements DAOInterface<OrderDetails> {

    private ConnectDB db = null;
    public DishDAO dishD = new DishDAO();
public ArrayList<Dish> dishes = new ArrayList<>();
    @Override
    public ArrayList<OrderDetails> selectAll() {
        db = ConnectDB.getInstance();
        ArrayList<OrderDetails> odList = new ArrayList<>();
        DishDAO dishDAO = new DishDAO();
        OrderDAO orderDAO = new OrderDAO();
        try {
            Connection conn = db.openConnection();
            PreparedStatement pst = conn.prepareStatement(MyQuery.ORDER_DETAILS);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idOrderDetails = rs.getInt("idOrderDetails");
                String typeOfPayment = rs.getString("typeOfPayment");
                int quantity = rs.getInt("quantity");
                int dishId = rs.getInt("dish_id");
                int orderId = rs.getInt("order_id");
                Dish dish = dishDAO.selectByID(dishId);
                Order order = orderDAO.selectByID(orderId);

                OrderDetails orderDetails = new OrderDetails(idOrderDetails, typeOfPayment, quantity, dish, order);
                odList.add(orderDetails);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return odList;
    }

    @Override
    public OrderDetails selectByID(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(OrderDetails t) {
        db = ConnectDB.getInstance();
        try {
                Connection conn = db.openConnection();
                PreparedStatement pst = conn.prepareStatement("insert into order_details(id,typeOfPayment,quantity,idOrder,idDish) values (?, ?, ? , ? , ?);");
                pst.setInt(1, t.getId());
                pst.setString(2,t.getTypePayMent());
                pst.setInt(3, t.getQuantity());
                pst.setInt(4, t.getOrder().getIdOrder());
                pst.setInt(5, t.getDish().getIdDish());
                pst.executeUpdate(); 
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    t.setId(id);
                }
        } catch (Exception e) {
            System.out.println("Error in adding order details: " + e.getMessage());
        }
    }



    @Override
    public void insertAll(ArrayList<OrderDetails> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll(OrderDetails t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(OrderDetails tt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OrderDetails> selectByName(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
