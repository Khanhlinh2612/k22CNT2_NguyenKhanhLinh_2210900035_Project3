<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý Cửa hàng Giày Thể Thao</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            color: #333;
            line-height: 1.6;
        }
        .header, .footer {
            background-color: #1e272e;
            color: #ffffff;
            text-align: center;
            padding: 15px 0;
        }
        .content {
            padding: 20px;
            max-width: 1100px;
            margin: 20px auto;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            font-size: 24px;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            padding: 10px 20px;
            background: #ff6b6b;
            color: white;
            text-decoration: none;
            font-weight: bold;
            border-radius: 5px;
            transition: background 0.3s;
        }
        a:hover {
            background: #ee5253;
        }
        p {
            margin-bottom: 15px;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Quản lý Cửa hàng Giày Thể Thao</h1>
    </div>
    <div class="content">
        <% 
            String message = "Chào mừng bạn đến với hệ thống quản lý cửa hàng giày thể thao!";
            out.print("<p>" + message + "</p>");
        %>
        <a href="nklmenu">Truy cập Quản lý</a>
    </div>
    <div class="footer">
        <p>&copy; 2025 Nguyễn Khánh Linh - Hệ thống quản lý cửa hàng giày thể thao.</p>
    </div>
</body>
</html>
