package com.springmvc.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springmvc.beans.NklNhanVien;
import com.springmvc.dao.NklNhanVienDao;
import com.springmvc.enums.NklChucVu;

@Controller
@RequestMapping("/nklnhanvien")
public class NklNhanVienController {

    @Autowired  
    private NklNhanVienDao dao;

    // ✅ Hiển thị danh sách nhân viên
    @GetMapping("/nklview")
    public String viewNhanVien(Model m) {
        List<NklNhanVien> list = dao.getAllNhanViens();
        m.addAttribute("list", list);
        return "nklnhanvien/nklview";
    }

    // ✅ Hiển thị form thêm nhân viên mới
    @GetMapping("/nklform")
    public String showForm(Model m) {
        m.addAttribute("command", new NklNhanVien());
        m.addAttribute("chucVuList", NklChucVu.values());
        return "nklnhanvien/nklform";
    }

    // ✅ Lưu nhân viên mới
    @PostMapping("/save")
    public String save(@ModelAttribute("nhanVien") NklNhanVien nhanVien) {
        if (nhanVien.getNklChucVu() == null) {
            nhanVien.setNklChucVu(NklChucVu.NHAN_VIEN);
        }
        dao.save(nhanVien);
        return "redirect:/nklnhanvien/nklview";
    }

    // ✅ Hiển thị form chỉnh sửa nhân viên
    @GetMapping("/nkledit/{nklIdNV}")
    public String edit(@PathVariable int nklIdNV, Model m) {
        Optional<NklNhanVien> optionalNhanVien = dao.getNhanVienById(nklIdNV);
        if (optionalNhanVien.isPresent()) {
            m.addAttribute("command", optionalNhanVien.get());
            m.addAttribute("chucVuList", NklChucVu.values());
            return "nklnhanvien/nkledit";
        }
        return "redirect:/nklnhanvien/nklview";
    }

    // ✅ Lưu chỉnh sửa nhân viên
    @PostMapping("/nkleditsave")
    public String editSave(@ModelAttribute("command") NklNhanVien nklNhanVien) {
        System.out.println("🔍 Dữ liệu nhận được từ form:");
        System.out.println("Tên NV: " + nklNhanVien.getNklTenNV());
        System.out.println("Chức vụ: " + nklNhanVien.getNklChucVu().getValue()); // Kiểm tra dữ liệu nklChucVu
        System.out.println("Số ĐT: " + nklNhanVien.getNklSDT());
        System.out.println("Email: " + nklNhanVien.getNklEmail());
        System.out.println("Ngày vào làm: " + nklNhanVien.getNklNgayVaoLam());

        dao.update(nklNhanVien);
        return "redirect:/nklnhanvien/nklview";
    }



    // ✅ Xóa nhân viên
    @GetMapping("/nkldelete/{nklIdNV}")
    public String delete(@PathVariable int nklIdNV, Model m) {
        try {
            dao.delete(nklIdNV);
        } catch (Exception e) {
            m.addAttribute("error", "Không thể xóa nhân viên vì có dữ liệu liên quan!");
            return "nklnhanvien/nklview";
        }
        return "redirect:/nklnhanvien/nklview";
    }
}
