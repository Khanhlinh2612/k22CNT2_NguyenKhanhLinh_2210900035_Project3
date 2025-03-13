package com.springmvc.beans;

public class NklSanPham {
    private int nklMaSP;
    private String nklTenSP;
    private int nklMaLoai; // Lưu ID loại sản phẩm
    private String nklTenLoai; // 🔹 Thêm thuộc tính này
    private double nklGiaNhap;
    private int nklSoLuongTon;

    // ✅ Constructors
    public NklSanPham() {}

    public NklSanPham(int nklMaSP, String nklTenSP, int nklMaLoai, String nklDonViTinh, double nklGiaNhap, int nklSoLuongTon) {
        this.nklMaSP = nklMaSP;
        this.nklTenSP = nklTenSP;
        this.nklMaLoai = nklMaLoai;
        this.nklGiaNhap = nklGiaNhap;
        this.nklSoLuongTon = nklSoLuongTon;
    }

    // ✅ Getters và Setters
    public int getNklMaSP() {
        return nklMaSP;
    }

    public void setNklMaSP(int nklMaSP) {
        this.nklMaSP = nklMaSP;
    }

    public String getNklTenSP() {
        return nklTenSP;
    }

    public void setNklTenSP(String nklTenSP) {
        this.nklTenSP = nklTenSP;
    }

    public int getNklMaLoai() {
        return nklMaLoai;
    }

    public void setNklMaLoai(int nklMaLoai) {
        this.nklMaLoai = nklMaLoai;
    }

    public String getNklTenLoai() { // 🔹 Getter mới
        return nklTenLoai;
    }

    public void setNklTenLoai(String nklTenLoai) { // 🔹 Setter mới
        this.nklTenLoai = nklTenLoai;
    }



    public double getNklGiaNhap() {
        return nklGiaNhap;
    }

    public void setNklGiaNhap(double nklGiaNhap) {
        this.nklGiaNhap = nklGiaNhap;
    }

    public int getNklSoLuongTon() {
        return nklSoLuongTon;
    }

    public void setNklSoLuongTon(int nklSoLuongTon) {
        this.nklSoLuongTon = nklSoLuongTon;
    }
}
