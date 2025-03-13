<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm Nhập Kho</title>
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
    </style>
</head>
<body>
    <div class="header">
        <h1>Quản lý Nhập Kho</h1>
    </div>

    <div class="content">
        <h2 class="dashboard-title">Thêm Nhập Kho</h2>
        <form action="/SpringMVCPagination/nklnhapkho/save" method="post">
            <div class="form-group">
                <label for="nklMaNhapKho">Mã Nhập Kho:</label>
                <input type="text" class="form-control" id="nklMaNhapKho" name="nklMaNhapKho" value="${command.nklMaNhapKho}" required>
            </div>

            <div class="form-group">
                <label for="nklNgayNhap">Ngày Nhập:</label>
                <input type="date" class="form-control" id="nklNgayNhap" name="nklNgayNhap" value="${currentDate}" required>
            </div>

            <div class="form-group">
                <label for="nklIdNV">Nhân Viên:</label>
                <select class="form-control" id="nklIdNV" name="nklIdNV" required>
                    <c:forEach var="nv" items="${listNhanVien}">
                        <option value="${nv.nklIdNV}">${nv.nklTenNV}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="nklIdNCC">Nhà Cung Cấp:</label>
                <select class="form-control" id="nklIdNCC" name="nklIdNCC" required>
                    <c:forEach var="ncc" items="${listNhaCungCap}">
                        <option value="${ncc.nklIdNCC}">${ncc.nklTenNCC}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="nklTongSoLuong">Tổng Số Lượng:</label>
                <input type="number" class="form-control" id="nklTongSoLuong" name="nklTongSoLuong" required>
            </div>

            <div class="form-group">
                <label for="nklTongTien">Tổng Tiền:</label>
                <input type="number" class="form-control" id="nklTongTien" name="nklTongTien" step="0.01" required>
            </div>

            <div class="form-group">
                <label for="nklGhiChu">Ghi Chú:</label>
                <textarea class="form-control" id="nklGhiChu" name="nklGhiChu"></textarea>
            </div>

            <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Lưu</button>
            <a href="/SpringMVCPagination/nklnhapkho/nklview" class="btn btn-secondary"><i class="fas fa-arrow-left"></i> Quay Lại</a>
        </form>
    </div>
</body>
</html>
