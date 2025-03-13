package com.springmvc.beans;

public class NklNhaCungCap {
    private int nklIdNCC;
    private String nklTenNCC;
    private String nklDiaChi;
    private String nklSDT;
    private String nklEmail;

    public NklNhaCungCap() {}

    public NklNhaCungCap(int nklIdNCC, String nklTenNCC, String nklDiaChi, String nklSDT, String nklEmail) {
        this.nklIdNCC = nklIdNCC;
        this.nklTenNCC = nklTenNCC;
        this.nklDiaChi = nklDiaChi;
        this.nklSDT = nklSDT;
        this.nklEmail = nklEmail;
    }

    public int getNklIdNCC() {
        return nklIdNCC;
    }

    public void setNklIdNCC(int nklIdNCC) {
        this.nklIdNCC = nklIdNCC;
    }

    public String getNklTenNCC() {
        return nklTenNCC;
    }

    public void setNklTenNCC(String nklTenNCC) {
        this.nklTenNCC = nklTenNCC;
    }

    public String getNklDiaChi() {
        return nklDiaChi;
    }

    public void setNklDiaChi(String nklDiaChi) {
        this.nklDiaChi = nklDiaChi;
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
}
