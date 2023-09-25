<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Product Management</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 0;
    }

    #container {
      max-width: 600px;
      margin: 20px auto;
      padding: 20px;
      background-color: #ffffff;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    label {
      display: inline-block;
      width: 160px;
      font-weight: bold;
      margin-bottom: 5px;
    }

    input[type="text"] {
      width: 100%;
      padding: 8px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: #ffffff;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
      margin-right: 10px;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div id="container">
    <form>
      <label for="pno">Product ID:</label>
      <input type="text" id="pno" name="pno">
      <br><br>
      <label for="pname">Product Name:</label>
      <input type="text" id="pname" name="pname">
      <br><br>
      <label for="pprice">Product Price:</label>
      <input type="text" id="pprice" name="pprice">
      <br><br>
      <label for="pquantity">Product Quantity:</label>
      <input type="text" id="pquantity" name="pquantity">
      <br><br>
      <label for="pdiscount">Product Discount:</label>
      <input type="text" id="pdiscount" name="pdiscount">
      <br><br>
      <input type="submit" value="Add Product" onclick="form.action='add';">
      <input type="submit" value="Display Product" onclick="form.action='show'">
      <input type="submit" value="Add Customer" onclick="form.action='customerinfo';">
      <input type="submit" value="Delete Customer" onclick="form.action='deletepage';">
    </form>
  </div>
</body>
</html>
