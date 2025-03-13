package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.springmvc.beans.NklNhaCungCap;

@Repository
public class NklNhaCungCapDao {
    
    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // ✅ Thêm mới nhà cung cấp
    public int save(NklNhaCungCap ncc) {
        String sql = "INSERT INTO nkl_nhacungcap (nkl_TenNCC, nkl_DiaChi, nkl_SDT, nkl_Email) VALUES (?, ?, ?, ?)";
        return template.update(sql, ncc.getNklTenNCC(), ncc.getNklDiaChi(), ncc.getNklSDT(), ncc.getNklEmail());
    }

    // ✅ Cập nhật thông tin nhà cung cấp
    public int update(NklNhaCungCap ncc) {
        String sql = "UPDATE nkl_nhacungcap SET nkl_TenNCC=?, nkl_DiaChi=?, nkl_SDT=?, nkl_Email=? WHERE nkl_IdNCC=?";
        return template.update(sql, ncc.getNklTenNCC(), ncc.getNklDiaChi(), ncc.getNklSDT(), ncc.getNklEmail(), ncc.getNklIdNCC());
    }

    // ✅ Xóa nhà cung cấp theo ID
    public int delete(int nklIdNCC) {
        String sql = "DELETE FROM nkl_nhacungcap WHERE nkl_IdNCC=?";
        return template.update(sql, nklIdNCC);
    }

    // ✅ Lấy nhà cung cấp theo ID
    public NklNhaCungCap getNhaCungCapById(int nklIdNCC) {
        String sql = "SELECT * FROM nkl_nhacungcap WHERE nkl_IdNCC=?";
        try {
            return template.queryForObject(sql, new Object[]{nklIdNCC}, new NklNhaCungCapMapper());
        } catch (Exception e) {
            return null;
        }
    }

    // ✅ Lấy danh sách tất cả nhà cung cấp
    public List<NklNhaCungCap> getAllNhaCungCap() {
        String sql = "SELECT * FROM nkl_nhacungcap";
        return template.query(sql, new NklNhaCungCapMapper());
    }

    // ✅ Lớp ánh xạ ResultSet sang đối tượng NklNhaCungCap
    private static class NklNhaCungCapMapper implements RowMapper<NklNhaCungCap> {
        @Override
        public NklNhaCungCap mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new NklNhaCungCap(
                rs.getInt("nkl_IdNCC"),       // ✅ Đổi từ nklMaNCC → nklIdNCC
                rs.getString("nkl_TenNCC"),
                rs.getString("nkl_DiaChi"),
                rs.getString("nkl_SDT"),       // ✅ Đổi từ nklSoDienThoai → nklSDT
                rs.getString("nkl_Email")
            );
        }
    }
}
