package com.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.springmvc.beans.NklSanPham;

@Repository
public class NklSanPhamDao {
    
    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    // ✅ Cập nhật số lượng sản phẩm tồn kho
    public int updateSoLuongTon(int nklMaSP, int soLuongNhap) {
        String sql = "UPDATE nkl_sanpham SET nkl_SoLuongTon = nkl_SoLuongTon + ? WHERE nkl_IdSanPham = ?";
        return template.update(sql, soLuongNhap, nklMaSP);
    }

    // ✅ Thêm sản phẩm mới
    public int save(NklSanPham sp) {
        String sql = "INSERT INTO nkl_sanpham (nkl_TenSanPham, nkl_IdLoai, nkl_GiaNhap, nkl_SoLuongTon) VALUES (?, ?, ?, ?)";
        return template.update(sql, sp.getNklTenSP(), sp.getNklMaLoai(), sp.getNklGiaNhap(), sp.getNklSoLuongTon());
    }


    // ✅ Cập nhật sản phẩm
    public int update(NklSanPham sp) {
    	String sql = "UPDATE nkl_sanpham SET nkl_TenSanPham=?, nkl_IdLoai=?, nkl_GiaNhap=?, nkl_SoLuongTon=? WHERE nkl_IdSanPham=?";
    	return template.update(sql, sp.getNklTenSP(), sp.getNklMaLoai(), sp.getNklGiaNhap(), sp.getNklSoLuongTon(), sp.getNklMaSP());
   }

    // ✅ Xóa sản phẩm theo ID
    public int delete(int nklMaSP) {
        String sql = "DELETE FROM nkl_sanpham WHERE nkl_IdSanPham=?";
        return template.update(sql, nklMaSP);
    }

    // ✅ Lấy danh sách tất cả sản phẩm (JOIN với `nkl_loai_sanpham` để lấy `nkl_TenLoai`)
    public List<NklSanPham> getAllSanPhams() {
        String sql = "SELECT sp.*, lsp.nkl_TenLoai FROM nkl_sanpham sp " +
                     "LEFT JOIN nkl_loai_sanpham lsp ON sp.nkl_IdLoai = lsp.nkl_IdLoai";
        return template.query(sql, new NklSanPhamMapper());
    }

    // ✅ Lấy sản phẩm theo ID
    public NklSanPham getSanPhamById(int nklMaSP) {
        String sql = "SELECT sp.*, lsp.nkl_TenLoai FROM nkl_sanpham sp " +
                     "LEFT JOIN nkl_loai_sanpham lsp ON sp.nkl_IdLoai = lsp.nkl_IdLoai " +
                     "WHERE sp.nkl_IdSanPham=?";
        try {
            return template.queryForObject(sql, new Object[]{nklMaSP}, new NklSanPhamMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    // ✅ Lớp ánh xạ dữ liệu từ ResultSet sang NklSanPham
    private static class NklSanPhamMapper implements RowMapper<NklSanPham> {
        @Override
        public NklSanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
            NklSanPham sp = new NklSanPham(); // ✅ Sử dụng constructor mặc định
            sp.setNklMaSP(rs.getInt("nkl_IdSanPham"));
            sp.setNklTenSP(rs.getString("nkl_TenSanPham"));
            sp.setNklMaLoai(rs.getInt("nkl_IdLoai"));
            sp.setNklGiaNhap(rs.getDouble("nkl_GiaNhap"));
            sp.setNklSoLuongTon(rs.getInt("nkl_SoLuongTon"));
            sp.setNklTenLoai(rs.getString("nkl_TenLoai")); // 🔹 Gán tên loại sản phẩm từ JOIN
            return sp;
        }
    }


}
