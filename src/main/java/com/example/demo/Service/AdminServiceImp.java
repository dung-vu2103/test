package com.example.demo.Service;

import com.example.demo.Dto.AdminDto;
import com.example.demo.Dto.BookDto;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.model.Admin;
import com.example.demo.model.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Log4j2
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<AdminDto> get(Integer id) {
        List<Admin> list = adminRepository.search(id);
        log.info("list" + list);
        List<AdminDto> adminDtos = new ArrayList<>();
        if(list !=null){
            for (Admin amin : list) {
                adminDtos.add(new AdminDto(amin.getId(), amin.getName(),amin.getTen(), getBook(amin.getBooks())));
            }
        }

        return adminDtos;
    }

    @Override
    public List<Admin> getAdmin(Integer id) {
        return adminRepository.search(id);
    }

    @Override
    public void create(String name, String ten) {
        adminRepository.create(name,ten);
    }


    private List<BookDto> getBook(List<Book> list) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : list) {
            bookDtos.add(new BookDto(book.getId(), book.getName()));
        }
        return bookDtos;
    }
}
