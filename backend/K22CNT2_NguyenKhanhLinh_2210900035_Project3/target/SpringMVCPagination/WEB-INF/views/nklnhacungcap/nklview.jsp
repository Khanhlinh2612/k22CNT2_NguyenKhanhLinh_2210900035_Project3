<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản Lý Nhà Cung Cấp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        /* Header */
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
            max-width: 1100px;
            margin: 20px auto;
            background: #ffffff;
            border-radius: 8px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .dashboard-title {
            font-size: 26px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .table th, .table td {
            vertical-align: middle;
            text-align: center;
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
            <a href="/SpringMVCPagination/nklphieunhap/nklview"><i class="fas fa-file-import"></i> Quản Lý Nhập Kho</a>
            <a href="http://localhost:8080/SpringMVCPagination/"><i class="fas fa-arrow-left"></i> Quay Lại Trang Chủ</a>
        </div>
    </div>

    <div class="content">
        <h2 class="dashboard-title">Danh Sách Nhà Cung Cấp</h2>
        <a href="/SpringMVCPagination/nklnhacungcap/nklform" class="btn btn-success mb-3">
            <i class="fas fa-plus"></i> Thêm Nhà Cung Cấp
        </a>
        <table class="table table-striped table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Tên Nhà Cung Cấp</th>
                    <th>Địa Chỉ</th>
                    <th>Số Điện Thoại</th>
                    <th>Email</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ncc" items="${list}">
                    <tr>
                        <td>${ncc.nklIdNCC}</td>
                        <td>${ncc.nklTenNCC}</td>
                        <td>${ncc.nklDiaChi}</td>
                        <td>${ncc.nklSDT}</td>
                        <td>${ncc.nklEmail}</td>
                        <td>
                            <a href="/SpringMVCPagination/nklnhacungcap/nkledit/${ncc.nklIdNCC}" class="btn btn-warning btn-sm">
                                <i class="fas fa-edit"></i> Sửa
                            </a>
                            <a href="/SpringMVCPagination/nklnhacungcap/nkldelete/${ncc.nklIdNCC}" 
                               class="btn btn-danger btn-sm" 
                               onclick="return confirm('Bạn có chắc muốn xóa nhà cung cấp này?')">
                                <i class="fas fa-trash"></i> Xóa
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
