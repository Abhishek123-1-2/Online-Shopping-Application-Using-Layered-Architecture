<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Purchase Success</title>
    <style>
        /* Your CSS styles here */
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

        .back-button {
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

        .back-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>Purchase Success</h1>

<h2>Purchased Records</h2>
<table>
    <tr>
        <th>Product No</th>
        <th>Product Name</th>
        <th>Product Price</th>
        <th>Discount</th>
    </tr>
    <%
    List<in.mindcraft.pojos.PurchasedRecord> purchasedRecords = (List<in.mindcraft.pojos.PurchasedRecord>) request.getAttribute("purchasedRecords");
    for (int i = 0; i < purchasedRecords.size(); i++) {
        in.mindcraft.pojos.PurchasedRecord record = purchasedRecords.get(i);
    %>
    <tr>
        <td><%= record.getProduct_no() %></td>
        <td><%= record.getProduct_name() %></td>
        <td><%= record.getProduct_price() %></td>
        <td><%= record.getDiscount() %>%</td>
    </tr>
    <%
    }
    %>
</table>

<h2 class="total-amount">Total Amount Paid: $<%= request.getAttribute("totalAmountToBePaid") %></h2>

<!-- Back button to return to the previous page -->
<a href="javascript:history.back();" class="back-button">Back</a>
</body>
</html>
