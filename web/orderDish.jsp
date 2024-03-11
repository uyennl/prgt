<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.entity.Dish" %>
<%@page import="model.entity.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .product {
                border: 1px solid #ccc;
                border-radius: 5px;
                padding: 10px;
                margin-bottom: 20px;
                width: 200px;
                display: inline-block;
                vertical-align: top;
                margin-right: 20px;
            }

            .product img {
                width: 100%;
                height: auto;
                border-radius: 5px;
            }

            .product .title {
                font-weight: bold;
            }

            .product .price {
                color: #333;
            }

            .product button {
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                padding: 5px 10px;
                cursor: pointer;
                margin-top: 10px;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <h1>Order</h1>
        <%
            Customer cus = (Customer) session.getAttribute("seeUser");
        %>

        <form action="addOrder" method="post">
            <c:forEach items="${dishList}" var="dish">
                <div class="product">
                    <input type="hidden" name="order">
                    <img src="${dish.image}" alt="...">
                    <p class="title"><b>Dish:</b> ${dish.title}</p>
                    <p class="price"><b>Price:</b> ${dish.price} $</p>
                    <input type="hidden" name="idDish" value="${dish.idDish}">
                    <button value="submit">Add to order</button>

                </div>
            </c:forEach>
            <button><a href="orderDetails">Cart</a></button>
        </form>


    </body>
</html>
