package com.example.demo.Service;

import com.example.demo.Dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> get(Integer id);
    void up(Integer id,String name);
    void delete(Integer id);
}
