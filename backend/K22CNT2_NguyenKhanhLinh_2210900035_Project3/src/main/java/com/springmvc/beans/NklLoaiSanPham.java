package com.springmvc.beans;

public class NklLoaiSanPham {
    private int nklMaLoai;
    private String nklTenLoai;
    
    // 🟢 Constructor không tham số
    public NklLoaiSanPham() {
    }

    // 🟢 Constructor có tham số
    public NklLoaiSanPham(int nklMaLoai, String nklTenLoai) {
        this.nklMaLoai = nklMaLoai;
        this.nklTenLoai = nklTenLoai;
    }

    // 🔹 Getter và Setter
    public int getNklMaLoai() {
        return nklMaLoai;
    }

    public void setNklMaLoai(int nklMaLoai) {
        this.nklMaLoai = nklMaLoai;
    }

    public String getNklTenLoai() {
        return nklTenLoai;
    }

    public void setNklTenLoai(String nklTenLoai) {
        this.nklTenLoai = nklTenLoai;
    }
}
