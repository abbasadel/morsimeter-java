package com.tahrirsquad.morsimeter.controllers;

import com.tahrirsquad.morsimeter.services.CategoryService;
import com.tahrirsquad.morsimeter.services.PromiseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private CategoryService categoryService;

    private PromiseService promiseService;

    public IndexController(CategoryService categoryService, PromiseService promiseService) {
        this.categoryService = categoryService;
        this.promiseService = promiseService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("stats", promiseService.calcTotalStats());
        return "index";

    }
}
