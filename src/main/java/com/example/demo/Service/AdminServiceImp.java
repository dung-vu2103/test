package com.example.demo.Service;

import com.example.demo.Dto.AdminDto;
import com.example.demo.Dto.BookDto;
import com.example.demo.Repository.AdminRepository;
import com.example.demo.model.Admin;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdminServiceImp implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<AdminDto> get(Integer id) {
        List<Admin> list = adminRepository.search(id);
        List<AdminDto> adminDtos = new ArrayList<>();
        for (Admin amin : list) {
            adminDtos.add(new AdminDto(amin.getId(), amin.getName(), getBook(amin.getBooks())));
        }
        return adminDtos;
    }

    @Override
    public List<Admin> getAdmin(Integer id) {
        return adminRepository.search(id);
    }

    private List<BookDto> getBook(List<Book> list) {
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : list) {
            bookDtos.add(new BookDto(book.getId(), book.getName()));
        }
        return bookDtos;
    }
}
