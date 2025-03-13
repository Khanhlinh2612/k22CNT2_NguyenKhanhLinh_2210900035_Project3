package com.springmvc.controllers;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.springmvc.beans.NklSanPham;
import com.springmvc.dao.NklSanPhamDao;
import com.springmvc.dao.NklLoaiSanPhamDao;

@Controller
@RequestMapping("/nklsanpham")
public class NklSanPhamController {

    @Autowired  
    private NklSanPhamDao dao;

    @Autowired  
    private NklLoaiSanPhamDao loaiDao;
    @GetMapping("/nklmenu")
    public String showMenu(Model model) {
        return "nklmenu"; // Trả về view `nklmenu.jsp`
    }
    

    @GetMapping("/nklview")
    public String viewSanPham(Model m) {
        List<NklSanPham> list = dao.getAllSanPhams();
        m.addAttribute("list", list);
        return "nklsanpham/nklview";
    }

    @GetMapping("/nklform")
    public String showForm(Model m) {
        m.addAttribute("command", new NklSanPham());
        m.addAttribute("listLoaiSP", loaiDao.getAllLoaiSanPhams());
        return "nklsanpham/nklform";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute NklSanPham sanPham, 
                       @RequestParam(value = "nklTenLoaiMoi", required = false) String nklTenLoaiMoi) { 
        if (nklTenLoaiMoi != null && !nklTenLoaiMoi.trim().isEmpty()) {
            int nklMaLoai = loaiDao.findOrCreateLoai(nklTenLoaiMoi);
            sanPham.setNklMaLoai(nklMaLoai);
        }
        dao.save(sanPham);
        return "redirect:/nklsanpham/nklview";
    }

    @PostMapping(value = "/addLoai", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String, Object> addLoai(@RequestParam("nklTenLoaiMoi") String nklTenLoaiMoi) {
        Map<String, Object> response = new HashMap<>();
        
        if (nklTenLoaiMoi != null && !nklTenLoaiMoi.trim().isEmpty()) {
            int nklMaLoai = loaiDao.findOrCreateLoai(nklTenLoaiMoi);
            response.put("success", true);
            response.put("nklMaLoai", nklMaLoai);
        } else {
            response.put("success", false);
            response.put("message", "Tên loại sản phẩm không hợp lệ!");
        }
        
        return response;
    }

    @DeleteMapping(value = "/deleteLoai", produces = "application/json")
    @ResponseBody
    public Map<String, Object> deleteLoai(@RequestParam("nklMaLoai") int nklMaLoai) {
        Map<String, Object> response = new HashMap<>();
        
        boolean isDeleted = loaiDao.deleteLoai(nklMaLoai);
        if (isDeleted) {
            response.put("success", true);
        } else {
            response.put("success", false);
            response.put("message", "Loại sản phẩm đang được sử dụng!");
        }
        
        return response;
    }
    
    @GetMapping("/nkledit/{nklMaSP}")
    public String edit(@PathVariable int nklMaSP, Model m) {
        NklSanPham sanPham = dao.getSanPhamById(nklMaSP);
        m.addAttribute("command", sanPham);
        m.addAttribute("listLoaiSP", loaiDao.getAllLoaiSanPhams());
        return "nklsanpham/nkledit";
    }

    @PostMapping("/nkleditsave")
    public String editSave(@ModelAttribute NklSanPham sanPham, 
                           @RequestParam(value = "nklTenLoaiMoi", required = false) String nklTenLoaiMoi) {
        if (nklTenLoaiMoi != null && !nklTenLoaiMoi.trim().isEmpty()) {
            int nklMaLoai = loaiDao.findOrCreateLoai(nklTenLoaiMoi);
            sanPham.setNklMaLoai(nklMaLoai);
        }
        dao.update(sanPham);
        return "redirect:/nklsanpham/nklview";
    }

    @GetMapping("/nkldelete/{nklMaSP}")
    public String delete(@PathVariable int nklMaSP) {
        dao.delete(nklMaSP);
        return "redirect:/nklsanpham/nklview";
    }
}
