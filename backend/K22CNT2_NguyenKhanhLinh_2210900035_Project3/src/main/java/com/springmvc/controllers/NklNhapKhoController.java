package com.springmvc.controllers;

import com.springmvc.beans.NklNhapKho;
import com.springmvc.dao.NklNhapKhoDao;
import com.springmvc.dao.NklNhanVienDao;
import com.springmvc.dao.NklNhaCungCapDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/nklnhapkho")
public class NklNhapKhoController {

    @Autowired
    private NklNhapKhoDao dao;

    @Autowired
    private NklNhanVienDao nhanVienDao;

    @Autowired
    private NklNhaCungCapDao nhaCungCapDao;

    // ✅ Xử lý chuyển đổi String -> Date
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    // ✅ Hiển thị danh sách Nhập Kho
    @GetMapping("/nklview")
    public String viewNhapKho(Model m) {
        List<NklNhapKho> list = dao.getAllNhapKho();
        m.addAttribute("list", list);
        return "nklnhapkho/nklview";
    }

    // ✅ Hiển thị form thêm Nhập Kho
    @GetMapping("/nklform")
    public String showForm(Model m) {
        m.addAttribute("command", new NklNhapKho());
        m.addAttribute("listNhanVien", nhanVienDao.getAllNhanViens());
        m.addAttribute("listNhaCungCap", nhaCungCapDao.getAllNhaCungCap());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        m.addAttribute("currentDate", sdf.format(new Date()));

        return "nklnhapkho/nklform";
    }

    // ✅ Lưu Nhập Kho mới
    @PostMapping("/save")
    public String save(@ModelAttribute NklNhapKho nhapKho) {
        try {
            dao.save(nhapKho);
            return "redirect:/nklnhapkho/nklview";
        } catch (Exception e) {
            System.err.println("Lỗi khi lưu Nhập Kho: " + e.getMessage());
            return "redirect:/nklnhapkho/nklform?error=true";
        }
    }

    // ✅ Hiển thị form chỉnh sửa Nhập Kho
    @GetMapping("/nkledit/{nklIdNhapKho}")
    public String edit(@PathVariable int nklIdNhapKho, Model m) {
        NklNhapKho nhapKho = dao.getNhapKhoById(nklIdNhapKho);
        if (nhapKho == null) {
            return "redirect:/nklnhapkho/nklview?notfound=true";
        }
        m.addAttribute("command", nhapKho);
        m.addAttribute("listNhanVien", nhanVienDao.getAllNhanViens());
        m.addAttribute("listNhaCungCap", nhaCungCapDao.getAllNhaCungCap());

        return "nklnhapkho/nkledit";
    }

    // ✅ Lưu chỉnh sửa Nhập Kho
    @PostMapping("/nkleditsave")
    public String editSave(@ModelAttribute NklNhapKho nhapKho) {
        try {
            dao.update(nhapKho);
            return "redirect:/nklnhapkho/nklview";
        } catch (Exception e) {
            System.err.println("Lỗi khi cập nhật Nhập Kho: " + e.getMessage());
            return "redirect:/nklnhapkho/nkledit/" + nhapKho.getNklIdNhapKho() + "?error=true";
        }
    }

    // ✅ Xóa Nhập Kho
    @GetMapping("/nkldelete/{nklIdNhapKho}")
    public String delete(@PathVariable int nklIdNhapKho) {
        try {
            dao.delete(nklIdNhapKho);
            return "redirect:/nklnhapkho/nklview";
        } catch (Exception e) {
            System.err.println("Lỗi khi xóa Nhập Kho: " + e.getMessage());
            return "redirect:/nklnhapkho/nklview?deleteerror=true";
        }
    }
}
