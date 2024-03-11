<%-- 
    Document   : mycard
    Created on : Mar 11, 2024, 9:30:19 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shop card!</h1>
        <table border ="1px" width="40%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quatity</th>
                <th>Price</th>
                <th>Total Monney</th>
                <th>Action</th>
            </tr>
            <c:set var="o" value="${requestScope.cart}"/>
            <c:set var="tt" value="0"/>
            <c:forEach items = "${o.items}" var="i">
                <c:set var="tt" value="${tt+1}"/>
                <tr>
                    <td>${tt}</td>
                    <td>${i.dish.title}</td>
                    <td>
                        <button><a href="process?num-1&id=${i.dish.idDish}">-</a></button>
                        ${i.quantity}
                        <button><a href="process?num-1&id=${i.dish.idDish}">-</a></button>
                    </td>
                    <td>${i.price}</td>
                    <td ${(i.price*i.quantity)} ></td>
                    <td>

                        <form action="process" method="post">
                            <input type="hidden" name="id" value="${i.dish.idDish}"
                                   <input type="submit" value="return item"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h3>Total money: ${o.totalMoney}</h3>
        <hr/>
        <form action="checkout" method="post">
            <input type="submit" value="Check Out"/>
        </form>
        <hr/><!-- comment -->
        <a href="shop">CLICK ME TO CONTINUTE SHOPING </a>
    </body>
</html>
