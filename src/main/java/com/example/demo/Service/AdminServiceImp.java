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
        log.info("listtt" +list);
        log.info("idd" +id);
        List<AdminDto> adminDtos = new ArrayList<>();
        for (Admin amin : list) {

            adminDtos.add(new AdminDto(amin.getId(), amin.getAdmin_name(), amin.getTen(),
                    getBookDto(amin.getBooks())));

        }
        return adminDtos;
    }


    @Override
    public void create(String name, String ten) {
        adminRepository.create(name, ten);
    }

    @Override
    public void up(Integer id, String name, String ten) {
        adminRepository.update1(id, name, ten);
    }

    @Override
    public void delete1(Integer id) {
        adminRepository.delete(id);
    }


    private List<BookDto> getBookDto(List<Book> list) {
        List<BookDto> bookDtos = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (Book book : list) {
                bookDtos.add(new BookDto(book.getId(), book.getName()));
            }
        }
        return bookDtos;
    }
}
