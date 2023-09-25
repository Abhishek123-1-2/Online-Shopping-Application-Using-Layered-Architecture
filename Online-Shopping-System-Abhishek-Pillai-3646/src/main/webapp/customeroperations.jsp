<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome Customer</title>
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

    span {
      color: red;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: #ffffff;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
      margin: 5px 0;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <h1>Welcome, <span>Customer</span></h1>
  <form>
  <input type="submit" value="Add product to Cart" onclick="form.action='productlist';">
  <input type="submit" value="Display Bill and Pay Bill" onclick="form.action='displayBill';">
  </form>
  
</body>
</html>

