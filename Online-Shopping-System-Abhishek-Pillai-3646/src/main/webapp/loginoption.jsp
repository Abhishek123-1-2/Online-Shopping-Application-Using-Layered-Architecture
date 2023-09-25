<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login Selection</title>
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

    form {
      background-color: #ffffff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    input[type="submit"] {
      background-color: #4CAF50;
      color: #ffffff;
      border: none;
      padding: 10px 20px;
      border-radius: 4px;
      cursor: pointer;
      margin: 10px;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <form>
    <input type="submit" value="Login as Administrator" onclick="form.action='adminlog';">
    <br><br>
    <input type="submit" value="Login as Customer" onclick="form.action='customerlog';">
  </form>
</body>
</html>

