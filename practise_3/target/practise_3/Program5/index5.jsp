<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>

<html>
    <head>
        <title>Page-5</title>
    </head>
    <body>
        <%@ include file="db-config.jsp" %>

        <sql:transaction dataSource="${db}">
            <!--Insert into orders table-->
            <sql:update var="orderResult">
                INSERT INTO orders(customer_name, total_amount)
                VALUES ("Dillip Jena", 2500.00)
            </sql:update>

            <!--Insert into order items-->
            <sql:update var="itemResult">
                INSERT INTO order_items(order_id, product, price)
                VALUES (LAST_INSERT_ID(), 'Laptop Bag', 2500.00)
            </sql:update>
        </sql:transaction>

        <p>Order and items inserted successfully using transaction!</p>

    </body>
</html>