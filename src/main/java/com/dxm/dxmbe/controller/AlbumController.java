package com.dxm.dxmbe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/albumn")
@CrossOrigin(value = "*", maxAge = 3600)
public class AlbumController {

    @GetMapping("/checkStatus")
    public String checkStatus(){
        return "ok";
    }

}
