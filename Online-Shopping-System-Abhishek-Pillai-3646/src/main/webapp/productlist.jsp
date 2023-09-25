<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
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
  input[type="submit"] {
    padding: 5px 10px;
    background-color: #4CAF50;
    color: white;
    border: none;
    cursor: pointer;
  }
</style>
</head>
<body>
<h1>Available Products</h1>
<table>
  <tr>
    <th>Product No</th>
    <th>Product Name</th>
    <th>Product Price</th>
    <th>Product Quantity</th>
    <th>Action</th>
  </tr>
  <%
  List<in.mindcraft.pojos.Product> products = (List<in.mindcraft.pojos.Product>) request.getAttribute("products");
  for (in.mindcraft.pojos.Product product : products) {
  %>
  <tr>
    <td><%= product.getProduct_no() %></td>
    <td><%= product.getProduct_name() %></td>
    <td><%= product.getProduct_price() %></td>
    <td><%=product.getQuantity() %></td>
    <form>
    <td><input type="submit" value="Add to Cart" onclick="form.action='addToCart'"></td>
     <input type="hidden" name="productId" value="<%= product.getProduct_no() %>">
    </form>
    
  </tr>
  <%
  }
  %>
</table>
</body>
</html>