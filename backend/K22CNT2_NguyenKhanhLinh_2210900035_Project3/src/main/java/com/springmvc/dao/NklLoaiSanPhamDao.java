package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.springmvc.beans.NklLoaiSanPham;

@Repository
public class NklLoaiSanPhamDao {

    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // ✅ Lấy danh sách tất cả loại sản phẩm
    public List<NklLoaiSanPham> getAllLoaiSanPhams() {
        String sql = "SELECT * FROM nkl_loai_sanpham";
        return template.query(sql, new NklLoaiSanPhamMapper());
    }
    
    // ✅ Xóa loại sản phẩm nếu không có sản phẩm nào đang sử dụng
    public boolean deleteLoai(int nklMaLoai) {
        String checkSql = "SELECT COUNT(*) FROM nkl_sanpham WHERE nkl_IdLoai = ?";
        int count = template.queryForObject(checkSql, new Object[]{nklMaLoai}, Integer.class);

        if (count > 0) {
            return false; // Không thể xóa vì có sản phẩm đang dùng loại này
        }

        String deleteSql = "DELETE FROM nkl_loai_sanpham WHERE nkl_IdLoai = ?";
        template.update(deleteSql, nklMaLoai);
        return true;
    }
        
    // ✅ Tìm hoặc thêm mới loại sản phẩm nếu chưa tồn tại
    public int findOrCreateLoai(String nklTenLoai) {
        String checkSql = "SELECT nkl_IdLoai FROM nkl_loai_sanpham WHERE nkl_TenLoai = ?";
        try {
            return template.queryForObject(checkSql, new Object[]{nklTenLoai}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            // 🔹 Thêm mới loại sản phẩm nếu chưa có
            String insertSql = "INSERT INTO nkl_loai_sanpham (nkl_TenLoai) VALUES (?)";
            template.update(insertSql, nklTenLoai);
            
            // 🔹 Lấy ID mới nhất vừa chèn (tránh lỗi khi nhiều luồng chạy đồng thời)
            return template.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        }
    }

    // ✅ Lớp ánh xạ ResultSet sang đối tượng NklLoaiSanPham
    private static class NklLoaiSanPhamMapper implements RowMapper<NklLoaiSanPham> {
        @Override
        public NklLoaiSanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new NklLoaiSanPham(
                rs.getInt("nkl_IdLoai"),
                rs.getString("nkl_TenLoai")
            );
        }
    }
}
