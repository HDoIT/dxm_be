package com.dxm.dxmbe.controller;

import com.dxm.dxmbe.model.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(value = "*",maxAge = 3600)
public class CategoryController {

    @GetMapping("/checkStatus")
    public String checkStatus(){
        return "ok";
    }

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category){
        return "ok";
    }
}
