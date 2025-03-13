package com.springmvc.beans;

import com.springmvc.enums.NklChucVu;

public class NklNhanVien {
    private int nklIdNV;
    private String nklTenNV;
    private NklChucVu nklChucVu;
    private String nklSDT;
    private String nklEmail;
    private String nklNgayVaoLam;

    public NklNhanVien() {
        this.nklChucVu = NklChucVu.NHAN_VIEN; // Mặc định là nhân viên
    }

    public NklNhanVien(int nklIdNV, String nklTenNV, NklChucVu nklChucVu, String nklSDT, String nklEmail, String nklNgayVaoLam) {
        this.nklIdNV = nklIdNV;
        this.nklTenNV = nklTenNV;
        this.nklChucVu = nklChucVu;
        this.nklSDT = nklSDT;
        this.nklEmail = nklEmail;
        this.nklNgayVaoLam = nklNgayVaoLam;
    }

    public int getNklIdNV() {
        return nklIdNV;
    }

    public void setNklIdNV(int nklIdNV) {
        this.nklIdNV = nklIdNV;
    }

    public String getNklTenNV() {
        return nklTenNV;
    }

    public void setNklTenNV(String nklTenNV) {
        this.nklTenNV = nklTenNV;
    }

    public NklChucVu getNklChucVu() {
        return nklChucVu;
    }

    public void setNklChucVu(NklChucVu nklChucVu) {
        this.nklChucVu = nklChucVu;
    }

    public void setNklChucVu(String nklChucVu) {
        this.nklChucVu = NklChucVu.fromString(nklChucVu);
    }

    public String getNklSDT() {
        return nklSDT;
    }

    public void setNklSDT(String nklSDT) {
        this.nklSDT = nklSDT;
    }

    public String getNklEmail() {
        return nklEmail;
    }

    public void setNklEmail(String nklEmail) {
        this.nklEmail = nklEmail;
    }

    public String getNklNgayVaoLam() {
        return nklNgayVaoLam;
    }

    public void setNklNgayVaoLam(String nklNgayVaoLam) {
        this.nklNgayVaoLam = nklNgayVaoLam;
    }
}
