package com.springmvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springmvc.beans.NklNhaCungCap;
import com.springmvc.dao.NklNhaCungCapDao;

@Controller
@RequestMapping("/nklnhacungcap")
public class NklNhaCungCapController {

    @Autowired  
    private NklNhaCungCapDao dao;

    // ✅ Hiển thị danh sách nhà cung cấp
    @GetMapping("/nklview")
    public String viewNhaCungCap(Model m) {
        List<NklNhaCungCap> list = dao.getAllNhaCungCap();
        m.addAttribute("list", list);
        return "nklnhacungcap/nklview";
    }

    // ✅ Hiển thị form thêm nhà cung cấp mới
    @GetMapping("/nklform")
    public String showForm(Model m) {
        m.addAttribute("command", new NklNhaCungCap());
        return "nklnhacungcap/nklform";
    }

    // ✅ Lưu nhà cung cấp mới vào database
    @PostMapping("/save")
    public String save(@ModelAttribute("nhaCungCap") NklNhaCungCap nhaCungCap) {
        dao.save(nhaCungCap);
        return "redirect:/nklnhacungcap/nklview";
    }

    // ✅ Hiển thị form chỉnh sửa nhà cung cấp
    @GetMapping("/nkledit/{nklIdNCC}")
    public String edit(@PathVariable int nklIdNCC, Model m) {
        NklNhaCungCap nhaCungCap = dao.getNhaCungCapById(nklIdNCC);
        m.addAttribute("command", nhaCungCap);
        return "nklnhacungcap/nkledit";
    }

    // ✅ Lưu chỉnh sửa nhà cung cấp
    @PostMapping("/nkleditsave")
    public String editSave(@ModelAttribute("nhaCungCap") NklNhaCungCap nhaCungCap) {
        dao.update(nhaCungCap);
        return "redirect:/nklnhacungcap/nklview";
    }

    // ✅ Xóa nhà cung cấp theo ID
    @GetMapping("/nkldelete/{nklIdNCC}")
    public String delete(@PathVariable int nklIdNCC) {
        dao.delete(nklIdNCC);
        return "redirect:/nklnhacungcap/nklview";
    }
}
