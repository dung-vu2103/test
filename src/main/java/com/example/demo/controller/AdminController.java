package com.example.demo.controller;

import com.example.demo.Dto.AdminDto;
import com.example.demo.Service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    AdminService adminService;

    @GetMapping("/get")
    public ResponseEntity<?> get1(@RequestParam(value = "id",required = false) Integer id) {
        List<AdminDto> adminDtos = adminService.get(id);
        return ResponseEntity.ok().body(adminDtos);

    }
}
