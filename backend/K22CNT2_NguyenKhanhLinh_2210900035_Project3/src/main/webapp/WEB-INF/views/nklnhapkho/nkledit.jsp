<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chỉnh Sửa Nhập Kho</title>
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
        <h1>Chỉnh Sửa Nhập Kho</h1>
    </div>

    <div class="content">
        <h2 class="dashboard-title">Cập Nhật Thông Tin Nhập Kho</h2>
        <form action="${pageContext.request.contextPath}/nklnhapkho/nkleditsave" method="post">
            <input type="hidden" name="nklIdNhapKho" value="${command.nklIdNhapKho}">

            <div class="form-group">
                <label>Mã Nhập Kho:</label>
                <input type="text" class="form-control" name="nklMaNhapKho" value="${command.nklMaNhapKho}" required>
            </div>

            <div class="form-group">
                <label>Ngày Nhập:</label>
                <input type="date" class="form-control" name="nklNgayNhap" value="${command.nklNgayNhap}" required>
            </div>

            <div class="form-group">
                <label>Nhân Viên:</label>
                <select class="form-control" name="nklIdNV">
                    <c:forEach var="nv" items="${listNhanVien}">
                        <option value="${nv.nklIdNV}" ${nv.nklIdNV == command.nklIdNV ? 'selected' : ''}>${nv.nklTenNV}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label>Nhà Cung Cấp:</label>
                <select class="form-control" name="nklIdNCC">
                    <c:forEach var="ncc" items="${listNhaCungCap}">
                        <option value="${ncc.nklIdNCC}" ${ncc.nklIdNCC == command.nklIdNCC ? 'selected' : ''}>${ncc.nklTenNCC}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label>Tổng Số Lượng:</label>
                <input type="number" class="form-control" name="nklTongSoLuong" value="${command.nklTongSoLuong}" required>
            </div>

            <div class="form-group">
                <label>Tổng Tiền:</label>
                <input type="number" class="form-control" name="nklTongTien" value="${command.nklTongTien}" step="0.01" required>
            </div>

            <div class="form-group">
                <label>Ghi Chú:</label>
                <textarea class="form-control" name="nklGhiChu">${command.nklGhiChu}</textarea>
            </div>

            <button type="submit" class="btn btn-primary"><i class="fas fa-save"></i> Lưu</button>
            <a href="/SpringMVCPagination/nklnhapkho/nklview" class="btn btn-secondary"><i class="fas fa-arrow-left"></i> Hủy</a>
        </form>
    </div>
</body>
</html>
