package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.beans.NklNhanVien;
import com.springmvc.enums.NklChucVu;

@Repository
public class NklNhanVienDao {
    
    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // ✅ Thêm nhân viên mới
    public int save(NklNhanVien nv) {
        String sql = "INSERT INTO nkl_nhanvien (nkl_TenNV, nkl_ChucVu, nkl_SDT, nkl_Email, nkl_NgayVaoLam) VALUES (?, ?, ?, ?, ?)";
        return template.update(sql, 
            nv.getNklTenNV(), 
            nv.getNklChucVu().getValue(), // 🔹 Chắc chắn lấy giá trị hợp lệ
            nv.getNklSDT(), 
            nv.getNklEmail(), 
            nv.getNklNgayVaoLam()
        );
    }

    // ✅ Cập nhật nhân viên
    public int update(NklNhanVien nv) {
        String sql = "UPDATE nkl_nhanvien SET nkl_TenNV=?, nkl_ChucVu=?, nkl_SDT=?, nkl_Email=?, nkl_NgayVaoLam=? WHERE nkl_IdNV=?";
        String chucVu = (nv.getNklChucVu() != null) ? nv.getNklChucVu().name() : NklChucVu.NHAN_VIEN.name();
        return template.update(sql, nv.getNklTenNV(), chucVu, nv.getNklSDT(), nv.getNklEmail(), nv.getNklNgayVaoLam(), nv.getNklIdNV());
    }

    // ✅ Xóa nhân viên
    public int delete(int nklIdNV) {
        String sql = "DELETE FROM nkl_nhanvien WHERE nkl_IdNV=?";
        return template.update(sql, nklIdNV);
    }

    // ✅ Lấy nhân viên theo ID
    public Optional<NklNhanVien> getNhanVienById(int nklIdNV) {
        String sql = "SELECT * FROM nkl_nhanvien WHERE nkl_IdNV=?";
        try {
            return Optional.ofNullable(template.queryForObject(sql, new Object[]{nklIdNV}, new NklNhanVienMapper()));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    // ✅ Lấy danh sách nhân viên
    public List<NklNhanVien> getAllNhanViens() {
        String sql = "SELECT * FROM nkl_nhanvien";
        return template.query(sql, new NklNhanVienMapper());
    }

    // ✅ Lớp ánh xạ ResultSet sang NklNhanVien
    private static class NklNhanVienMapper implements RowMapper<NklNhanVien> {
        @Override
        public NklNhanVien mapRow(ResultSet rs, int rowNum) throws SQLException {
            NklNhanVien nv = new NklNhanVien();
            nv.setNklIdNV(rs.getInt("nkl_IdNV"));
            nv.setNklTenNV(rs.getString("nkl_TenNV"));
            nv.setNklSDT(rs.getString("nkl_SDT"));
            nv.setNklEmail(rs.getString("nkl_Email"));
            nv.setNklNgayVaoLam(rs.getString("nkl_NgayVaoLam"));

            // ✅ Xử lý enum tránh lỗi NullPointerException
            String chucVuStr = rs.getString("nkl_ChucVu");
            nv.setNklChucVu(chucVuStr != null ? NklChucVu.fromString(chucVuStr) : NklChucVu.NHAN_VIEN);

            return nv;
        }
    }
}
