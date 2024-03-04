package com.example.demo.Service;

import com.example.demo.Dto.AdminDto;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.controller.AdminController;
import com.example.demo.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {
    List<AdminDto> get(Integer id);

    List<Admin> getAdmin(Integer id);
    void create(String name,String ten);
    void up(Integer id,String name,String ten);
    void delete1(Integer id);

}
