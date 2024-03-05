package com.example.demo.controller;

import com.example.demo.Dto.AdminDto;
import com.example.demo.Service.AdminService;
import com.example.demo.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/get")
    public ResponseEntity<?> get1(@RequestParam(value = "id",required = false) Integer id) {
        List<AdminDto> adminDtos = adminService.get(id);
        return ResponseEntity.ok().body(adminDtos);

    }
    @PostMapping("/create")
    public  ResponseEntity<?> add(@RequestBody Admin admin){
        adminService.create(admin.getAdmin_name(),admin.getTen());
        return ResponseEntity.ok().build();
    }
    @PostMapping("/update")
    public  ResponseEntity<?> update(@RequestBody Admin admin){
        adminService.up(admin.getId(),admin.getAdmin_name(),admin.getTen());
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Integer id){
        adminService.delete1(id);
        return ResponseEntity.ok().build();
    }
}
