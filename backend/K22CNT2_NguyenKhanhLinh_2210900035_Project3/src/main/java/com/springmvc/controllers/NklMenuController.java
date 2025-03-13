package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NklMenuController {

    @GetMapping("/nklmenu")
    public String showMenu(Model model) {
        return "nklmenu"; // Trả về view `nklmenu.jsp`
    }
}
