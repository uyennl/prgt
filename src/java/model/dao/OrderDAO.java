/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import model.database.ConnectDB;
import model.entity.Order;
import java.sql.*;
import java.util.ArrayList;
import model.entity.Customer;
import model.utils.MyQuery;

/**
 *
 * @author PC
 */
public class OrderDAO implements DAOInterface<Order> {

    private ConnectDB db = null;
    public DishDAO dishD = new DishDAO();

    @Override
    public ArrayList<Order> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Order selectByID(int t) {
        Order order = null;
        db = ConnectDB.getInstance();
        CustomerDAO cusDAO = new CustomerDAO();
        try{
            Connection conn = db.openConnection();
            PreparedStatement pst = conn.prepareStatement("select * from orders where idOrder = ?;");
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int idOrder = rs.getInt("idOrder");
                int idCustomer = rs.getInt("idCustomer");
                Customer cus = cusDAO.selectByID(idCustomer);
                Date dateOfOrder = rs.getDate("dateOfOrder");
                order = new Order(idOrder,dateOfOrder,cus);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return order;
    }

    @Override
    public void insert(Order t) {
        db = ConnectDB.getInstance();
        CustomerDAO customerDAO = new CustomerDAO();
        try {
            Connection conn = db.openConnection();
            PreparedStatement pst = conn.prepareStatement(MyQuery.ORDER_DISH);
            pst.setDate(1, new Date(t.getDate().getTime()));
            pst.setInt(2, t.getCustomer().getIdCustomer());
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void insertAll(ArrayList<Order> arr) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteAll(Order t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Order tt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Order> selectByName(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
