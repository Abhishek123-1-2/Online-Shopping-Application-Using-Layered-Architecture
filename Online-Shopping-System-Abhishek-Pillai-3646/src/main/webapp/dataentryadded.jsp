<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Data Entry Result</title>
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

        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        p {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <%
        int pno = (int)session.getAttribute("pno");
        String pname = (String) session.getAttribute("pname");
        int pprice = (int) session.getAttribute("pprice");
        int pquantity = (int) session.getAttribute("pquantity");
        float pdiscount = (float) session.getAttribute("pdiscount");
        out.println("Data Entry<br>");
        out.println(pno+" "+pname+" "+pprice+" "+pquantity+" "+pdiscount+"<br>");
        out.println("Data Inserted Successfully");
        
        %>
    </div>
</body>
</html>
