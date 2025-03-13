package com.springmvc.dao;

import com.springmvc.beans.NklNhapKho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NklNhapKhoDao {

    private JdbcTemplate template;

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // ✅ Lấy danh sách tất cả Nhập Kho
    public List<NklNhapKho> getAllNhapKho() {
        String sql = "SELECT nk.*, nv.nkl_TenNV AS nklTenNhanVien, ncc.nkl_TenNCC AS nklTenNhaCungCap " +
                     "FROM nkl_nhapkho nk " +
                     "LEFT JOIN nkl_nhanvien nv ON nk.nkl_IdNV = nv.nkl_IdNV " +
                     "LEFT JOIN nkl_nhacungcap ncc ON nk.nkl_IdNCC = ncc.nkl_IdNCC";
        return template.query(sql, new NklNhapKhoMapper());
    }

    // ✅ Lấy Nhập Kho theo ID
    public NklNhapKho getNhapKhoById(int nklIdNhapKho) {
        String sql = "SELECT nk.*, nv.nkl_TenNV AS nklTenNhanVien, ncc.nkl_TenNCC AS nklTenNhaCungCap " +
                     "FROM nkl_nhapkho nk " +
                     "LEFT JOIN nkl_nhanvien nv ON nk.nkl_IdNV = nv.nkl_IdNV " +
                     "LEFT JOIN nkl_nhacungcap ncc ON nk.nkl_IdNCC = ncc.nkl_IdNCC " +
                     "WHERE nk.nkl_IdNhapKho = ?";
        try {
            return template.queryForObject(sql, new Object[]{nklIdNhapKho}, new NklNhapKhoMapper());
        } catch (Exception e) {
            return null;
        }
    }

    // ✅ Thêm mới Nhập Kho
    public int save(NklNhapKho nhapKho) {
        String sql = "INSERT INTO nkl_nhapkho (nkl_MaNhapKho, nkl_NgayNhap, nkl_IdNV, nkl_IdNCC, nkl_TongSoLuong, nkl_TongTien, nkl_GhiChu) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return template.update(sql, nhapKho.getNklMaNhapKho(), nhapKho.getNklNgayNhap(), nhapKho.getNklIdNV(), nhapKho.getNklIdNCC(), nhapKho.getNklTongSoLuong(), nhapKho.getNklTongTien(), nhapKho.getNklGhiChu());
    }

    // ✅ Cập nhật Nhập Kho
    public int update(NklNhapKho nhapKho) {
        String sql = "UPDATE nkl_nhapkho SET nkl_MaNhapKho=?, nkl_NgayNhap=?, nkl_IdNV=?, nkl_IdNCC=?, nkl_TongSoLuong=?, nkl_TongTien=?, nkl_GhiChu=? WHERE nkl_IdNhapKho=?";
        return template.update(sql, nhapKho.getNklMaNhapKho(), nhapKho.getNklNgayNhap(), nhapKho.getNklIdNV(), nhapKho.getNklIdNCC(), nhapKho.getNklTongSoLuong(), nhapKho.getNklTongTien(), nhapKho.getNklGhiChu(), nhapKho.getNklIdNhapKho());
    }

    // ✅ Xóa Nhập Kho
    public int delete(int nklIdNhapKho) {
        String sql = "DELETE FROM nkl_nhapkho WHERE nkl_IdNhapKho=?";
        return template.update(sql, nklIdNhapKho);
    }

    // ✅ Mapper để ánh xạ dữ liệu từ ResultSet sang đối tượng NklNhapKho
    private static class NklNhapKhoMapper implements RowMapper<NklNhapKho> {
        @Override
        public NklNhapKho mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new NklNhapKho(
                rs.getInt("nkl_IdNhapKho"),
                rs.getString("nkl_MaNhapKho"),
                rs.getDate("nkl_NgayNhap"),
                rs.getInt("nkl_IdNV"),
                rs.getInt("nkl_IdNCC"),
                rs.getInt("nkl_TongSoLuong"),
                rs.getDouble("nkl_TongTien"),
                rs.getString("nkl_GhiChu"),
                rs.getString("nklTenNhanVien"), // Lấy tên nhân viên
                rs.getString("nklTenNhaCungCap") // Lấy tên nhà cung cấp
            );
        }
    }
}
