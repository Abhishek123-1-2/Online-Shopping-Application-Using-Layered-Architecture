<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Bill</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        h2 {
            font-size: 18px;
            margin-bottom: 10px;
        }

        .total-amount {
            font-weight: bold;
            color: #333;
        }

        .payment-button {
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            text-decoration: none;
            margin-top: 20px;
            display: inline-block;
            cursor: pointer;
        }

        .payment-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Your Bill</h1>

<table>
    <tr>
        <th>Product No</th>
        <th>Product Name</th>
        <th>Product Price</th>
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
        <td><%= cartItem.getQuantity() %></td>
    </tr>
    <%
    }
    %>
</table>

<h2>Total Price: <%= request.getAttribute("totalPrice") %></h2>
<h2>Total Discount: <%= request.getAttribute("totalDiscount") %></h2>
<h2>Saved Amount: <%= request.getAttribute("savedAmount") %></h2>
<h2 class="total-amount">Total Amount to Be Paid: <%= request.getAttribute("totalAmountToBePaid") %></h2>

<!-- Proceed to Payment button -->
<form action="proceedToPayment">
    <input type="submit" value="Proceed to Payment" class="payment-button">
</form>

<!-- Add a button or link to go back to the previous page -->
<a href="javascript:history.back();" class="payment-button">Back</a>
</body>
</html>
