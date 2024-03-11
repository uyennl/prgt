/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;
import java.sql.Date;
import java.io.Serializable;

/**
 *
 * @author PC
 */
/*
    create table orders
(
	idOrder int primary key identity(1,1),
	dateOfOrder date not null,
	idCustomer int,
	constraint fk_orders_customer foreign key (idCustomer) REFERENCES customer(idCustomer)
);
 */
public class Order implements Serializable{

    private int idOrder;
    private Date date;
    private Customer customer;

    public Order() {

    }
    
    public Order(Date date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }
    
     public Order(int idOrder,Date date, Customer customer) {
        this.idOrder = idOrder;
        this.date = date;
        this.customer = customer;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", date=" + date + ", customer=" + customer + '}';
    }

   

}
