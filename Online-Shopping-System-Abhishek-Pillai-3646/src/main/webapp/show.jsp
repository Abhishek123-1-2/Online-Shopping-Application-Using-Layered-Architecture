<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product List</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    h1 {
      font-size: 24px;
      margin-bottom: 20px;
    }

    table {
      border-collapse: collapse;
      width: 80%;
      max-width: 800px;
      margin: 0 auto;
      background-color: #ffffff;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    th, td {
      border: 1px solid #ccc;
      padding: 8px;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
      font-weight: bold;
    }
  </style>
</head>
<body>
  <h1>Product List</h1>
  <table>
    <tr>
      <th>Product No</th>
      <th>Product Name</th>
      <th>Product Price</th>
      <th>Product Quantity</th>
      <th>Product Discount</th>
    </tr>
    <%
    List<in.mindcraft.pojos.Product> products = (List<in.mindcraft.pojos.Product>) request.getAttribute("products");
    for (in.mindcraft.pojos.Product product : products) {
    %>
    <tr>
      <td><%=product.getProduct_no()%></td>
      <td><%=product.getProduct_name()%></td>
      <td><%=product.getProduct_price()%></td>
      <td><%=product.getQuantity()%></td>
      <td><%=product.getDiscount()%></td>
    </tr>
    <%
    }
    %>
  </table>
</body>
</html>
