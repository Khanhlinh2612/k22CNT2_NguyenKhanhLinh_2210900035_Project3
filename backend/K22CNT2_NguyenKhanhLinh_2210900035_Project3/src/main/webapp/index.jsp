<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #f6d365, #fda085);
            color: #444;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .header, .footer {
            background: #ff6b81;
            color: #ffffff;
            text-align: center;
            padding: 20px 0;
        }
        .header h1, .header p {
            color: #fff7d6;
        }
        .content {
            flex: 1;
            padding: 30px;
            max-width: 900px;
            margin: auto;
            background: white;
            border-radius: 12px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
            text-align: center;
            animation: fadeIn 0.8s ease-in-out;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }
        h1 {
            font-size: 28px;
            font-weight: bold;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 12px 24px;
            background: #ff4757;
            color: white;
            text-decoration: none;
            font-weight: bold;
            border-radius: 8px;
            transition: all 0.3s;
        }
        a:hover {
            background: #e84118;
            transform: scale(1.05);
        }
        p {
            margin-bottom: 20px;
            font-size: 18px;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Hệ Thống Quản Lý Giày Thể Thao</h1>
        <p>Giúp bạn quản lý cửa hàng một cách dễ dàng và hiệu quả</p>
    </div>
    <div class="content">
        <% 
            String message = "Chào mừng bạn đến với hệ thống quản lý cửa hàng giày thể thao!";
            out.print("<p>" + message + "</p>");
        %>
        <p>Hệ thống cung cấp các chức năng quản lý sản phẩm, nhà cung cấp, đơn hàng và nhiều hơn nữa.</p>
        <a href="nklmenu">Bắt đầu quản lý</a>
    </div>
    <div class="footer">
        <p>&copy; 2025 Nguyễn Khánh Linh - Hệ thống quản lý cửa hàng giày thể thao.</p>
    </div>
</body>
</html>
