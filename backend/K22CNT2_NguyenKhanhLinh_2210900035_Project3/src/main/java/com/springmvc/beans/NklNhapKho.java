package com.springmvc.beans;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class NklNhapKho {
    private int nklIdNhapKho;
    private String nklMaNhapKho;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nklNgayNhap;

    private int nklIdNV;
    private int nklIdNCC;
    private int nklTongSoLuong;
    private double nklTongTien;
    private String nklGhiChu;
    
    private String nklTenNhanVien;
    private String nklTenNhaCungCap;

    public NklNhapKho() {
    }

    public NklNhapKho(int nklIdNhapKho, String nklMaNhapKho, Date nklNgayNhap, int nklIdNV, int nklIdNCC, int nklTongSoLuong, double nklTongTien, String nklGhiChu, String nklTenNhanVien, String nklTenNhaCungCap) {
        this.nklIdNhapKho = nklIdNhapKho;
        this.nklMaNhapKho = nklMaNhapKho;
        this.nklNgayNhap = nklNgayNhap;
        this.nklIdNV = nklIdNV;
        this.nklIdNCC = nklIdNCC;
        this.nklTongSoLuong = nklTongSoLuong;
        this.nklTongTien = nklTongTien;
        this.nklGhiChu = nklGhiChu;
        this.nklTenNhanVien = nklTenNhanVien;
        this.nklTenNhaCungCap = nklTenNhaCungCap;
    }

    public int getNklIdNhapKho() {
        return nklIdNhapKho;
    }

    public void setNklIdNhapKho(int nklIdNhapKho) {
        this.nklIdNhapKho = nklIdNhapKho;
    }

    public String getNklMaNhapKho() {
        return nklMaNhapKho;
    }

    public void setNklMaNhapKho(String nklMaNhapKho) {
        this.nklMaNhapKho = nklMaNhapKho;
    }

    public Date getNklNgayNhap() {
        return nklNgayNhap;
    }

    public void setNklNgayNhap(Date nklNgayNhap) {
        this.nklNgayNhap = nklNgayNhap;
    }

    public int getNklIdNV() {
        return nklIdNV;
    }

    public void setNklIdNV(int nklIdNV) {
        this.nklIdNV = nklIdNV;
    }

    public int getNklIdNCC() {
        return nklIdNCC;
    }

    public void setNklIdNCC(int nklIdNCC) {
        this.nklIdNCC = nklIdNCC;
    }

    public int getNklTongSoLuong() {
        return nklTongSoLuong;
    }

    public void setNklTongSoLuong(int nklTongSoLuong) {
        this.nklTongSoLuong = nklTongSoLuong;
    }

    public double getNklTongTien() {
        return nklTongTien;
    }

    public void setNklTongTien(double nklTongTien) {
        this.nklTongTien = nklTongTien;
    }

    public String getNklGhiChu() {
        return nklGhiChu;
    }

    public void setNklGhiChu(String nklGhiChu) {
        this.nklGhiChu = nklGhiChu;
    }
    
    public String getNklTenNhanVien() {
        return nklTenNhanVien;
    }

    public void setNklTenNhanVien(String nklTenNhanVien) {
        this.nklTenNhanVien = nklTenNhanVien;
    }

    public String getNklTenNhaCungCap() {
        return nklTenNhaCungCap;
    }

    public void setNklTenNhaCungCap(String nklTenNhaCungCap) {
        this.nklTenNhaCungCap = nklTenNhaCungCap;
    }
}
