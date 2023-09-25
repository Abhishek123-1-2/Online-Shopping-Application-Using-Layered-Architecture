<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a.button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<h1>Your Shopping Cart</h1>
<table>
    <tr>
        <th>Product No</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Product Discount</th>
        <th>Quantity</th>
    </tr>
    <%
        List<in.mindcraft.pojos.CartItem> cart = (List<in.mindcraft.pojos.CartItem>) request.getAttribute("cart");
        for (int i = 0; i < cart.size(); i++) {
            in.mindcraft.pojos.CartItem cartItem = cart.get(i);
    %>
    <tr>
        <td><%= cartItem.getProduct_no() %></td>
        <td><%= cartItem.getProduct_name() %></td>
        <td><%= cartItem.getProduct_price() %></td>
        <td><%= cartItem.getProduct_discount() %></td>
        <td><%= cartItem.getQuantity() %></td>
    </tr>
    <%
        }
    %>
</table>
 <a href="javascript:history.back();">Back to Previous Page</a>
</body>
</html>
