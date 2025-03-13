<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Quản Lý Cửa Hàng Giày Thể Thao</title>
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

        .stat-box {
            background: white;
            padding: 20px;
            border-radius: 8px;
            text-align: center;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        .stat-box i {
            font-size: 40px;
            color: #ff4757;
        }

        .stat-box h3 {
            margin-top: 10px;
            font-size: 22px;
        }

        .stat-box p {
            font-size: 18px;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>Quản lý Cửa hàng Giày Thể Thao</h1>
        <div class="nav-links">
            <a href="/SpringMVCPagination/nklmenu"><i class="fas fa-tachometer-alt"></i> Dashboard</a>
            <a href="/SpringMVCPagination/nklsanpham/nklview"><i class="fas fa-box"></i> Quản lý Sản Phẩm</a>
            <a href="/SpringMVCPagination/nklnhacungcap/nklview"><i class="fas fa-truck"></i>Quản Lý Nhà Cung Cấp</a>
            <a href="/SpringMVCPagination/nklnhanvien/nklview"><i class="fas fa-users"></i>Quản Lý Nhân Viên</a>
            <a href="/SpringMVCPagination/nklphieunhap/nklview"><i class="fas fa-file-import"></i> Quản Lý Nhập Kho</a>
            <a href="http://localhost:8080/SpringMVCPagination/"><i class="fas fa-arrow-left"></i> Quay Lại Trang Chủ</a>
        </div>
    </div>

    <div class="content">
        <h2 class="dashboard-title">Dashboard Quản Lý Cửa Hàng Giày Thể Thao</h2>
        <div class="row">
            <div class="col-md-4 mb-3">
                <a href="/SpringMVCPagination/nklsanpham/nklview">
                    <div class="stat-box">
                        <i class="fas fa-box"></i>
                        <h3 class="text-dark">Tổng Sản Phẩm</h3>
                        <p class="text-muted">${totalSanPham}</p>
                    </div>
                </a>
            </div>

            <div class="col-md-4 mb-3">
                <a href="/SpringMVCPagination/nklnhacungcap/nklview">
                    <div class="stat-box">
                        <i class="fas fa-truck"></i>
                        <h3 class="text-dark">Nhà Cung Cấp</h3>
                        <p class="text-muted">${totalNhaCungCap}</p>
                    </div>
                </a>
            </div>

            <div class="col-md-4 mb-3">
                <a href="/SpringMVCPagination/nklnhanvien/nklview">
                    <div class="stat-box">
                        <i class="fas fa-users"></i>
                        <h3 class="text-dark">Nhân Viên</h3>
                        <p class="text-muted">${totalNhanVien}</p>
                    </div>
                </a>
            </div>
            
            <div class="col-md-4 mb-3">
                <a href="/SpringMVCPagination/nklnhanvien/nklview">
                    <div class="stat-box">
                        <i class="fas fa-file-import"></i>
                        <h3 class="text-dark">Quản Lý Nhập Kho</h3>
                        <p class="text-muted">${totalNhapKho}</p>
                    </div>
                </a>
            </div>
        </div>
    </div>
</body>
</html>
