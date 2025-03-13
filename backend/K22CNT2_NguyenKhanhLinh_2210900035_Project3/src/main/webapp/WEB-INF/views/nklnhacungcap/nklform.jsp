<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhà Cung Cấp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .header {
            background: #1e272e;
            color: white;
            text-align: center;
            padding: 20px 0;
            font-size: 22px;
            font-weight: bold;
        }

        .nav-links {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-top: 10px;
        }

        .nav-links a {
            color: white;
            text-decoration: none;
            font-size: 18px;
            transition: color 0.3s;
        }

        .nav-links a:hover {
            color: #ffc107;
        }

        .content {
            padding: 20px;
            max-width: 600px;
            margin: 20px auto;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }

        .form-group label {
            font-weight: bold;
        }

        .btn-group {
            display: flex;
            justify-content: space-between;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Quản lý Cửa hàng Giày Thể Thao</h1>
        <div class="nav-links">
            <a href="/SpringMVCPagination/nklmenu"><i class="fas fa-tachometer-alt"></i> Dashboard</a>
            <a href="/SpringMVCPagination/nklsanpham/nklview"><i class="fas fa-box"></i> Quản lý Sản Phẩm</a>
            <a href="/SpringMVCPagination/nklnhacungcap/nklview"><i class="fas fa-truck"></i> Quản Lý Nhà Cung Cấp</a>
            <a href="/SpringMVCPagination/nklnhanvien/nklview"><i class="fas fa-users"></i> Quản Lý Nhân Viên</a>
            <a href="/SpringMVCPagination/nklnhapkho/nklview"><i class="fas fa-file-import"></i> Quản Lý Nhập Kho</a>
            <a href="http://localhost:8080/SpringMVCPagination/"><i class="fas fa-arrow-left"></i> Quay Lại Trang Chủ</a>
        </div>
    </div>

    <div class="content">
        <h2 class="dashboard-title">Thêm Nhà Cung Cấp</h2>

        <form action="/SpringMVCPagination/nklnhacungcap/save" method="post">
            <input type="hidden" name="nklIdNCC" value="${command.nklIdNCC}" />

            <div class="form-group">
                <label for="nklTenNCC">Tên Nhà Cung Cấp:</label>
                <input type="text" class="form-control" id="nklTenNCC" name="nklTenNCC" value="${command.nklTenNCC}" required>
            </div>

            <div class="form-group">
                <label for="nklDiaChi">Địa Chỉ:</label>
                <input type="text" class="form-control" id="nklDiaChi" name="nklDiaChi" value="${command.nklDiaChi}" required>
            </div>

            <div class="form-group">
                <label for="nklSDT">Số Điện Thoại:</label>
                <input type="text" class="form-control" id="nklSDT" name="nklSDT" value="${command.nklSDT}" required>
            </div>

            <div class="form-group">
                <label for="nklEmail">Email:</label>
                <input type="email" class="form-control" id="nklEmail" name="nklEmail" value="${command.nklEmail}" required>
            </div>

            <div class="btn-group">
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Lưu</button>
                <a href="/SpringMVCPagination/nklnhacungcap/nklview" class="btn btn-secondary"><i class="fas fa-arrow-left"></i> Quay Lại</a>
            </div>
        </form>
    </div>
</body>
</html>
