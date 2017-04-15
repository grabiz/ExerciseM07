<%-- 
    Document   : Order
    Created on : Apr 15, 2017, 8:42:43 AM
    Author     : NGUYEN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
    <jsp:include page="../include/header.jsp"/>
    <spring:form action="order" method="post">
        <table class="table table-hover">
            <tr>
                <th></th>
                <th>ID</th>
                <th>Branch</th>
                <th>Price</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>
            <c:forEach var="product" items="${cart.lineItems}">
                <tr>
                    <td>
                        <input type="checkbox" name="checkbox" value="${product.product.id}"> </td>
                    <td>${product.product.id}</td>
                    <td>${product.product.branch}</td>
                    <td>${product.product.price}</td>
                    <td>${product.product.description}</td>
                    <td><input type="hidden" name="quantityId" value="${product.product.id}">
                        <input type="number" name="quantityProd" min="1" placeholder="${product.quantity}"></td>
                    <td>${product.total}</td>
                </tr>
            </c:forEach>    
        </table>
        <button name="action" value="update"   type="submit" class="btn btn-primary">Update</button>
        <button name="action" value="remove"   type="submit" class="btn btn-danger">Remove</button>
    </spring:form><br>
    <spring:form action="continue">   
        <button type="submit" class="btn btn-success">Continue</button>
    </spring:form><br>
    <spring:form action="checkout">   
        <button type="submit" class="btn btn-warning">Checkout</button>
    </spring:form>
    
</div>
</body>
</html>
