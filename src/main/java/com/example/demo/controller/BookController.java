package com.example.demo.controller;

import com.example.demo.Dto.BookDto;
import com.example.demo.Service.BookService;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/get")
    public ResponseEntity<?> get(@RequestParam(value = "id",required = false) Integer id){
        List<BookDto> bookDtoList=bookService.get(id);
        return ResponseEntity.ok().body(bookDtoList);
    }
    @PostMapping("/update")
    public ResponseEntity<?> up(@RequestBody Book book){
        bookService.up(book.getId(),book.getName());
        return  ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete")
    public  ResponseEntity<?> delete(@RequestParam(value = "id") Integer id){
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }
}
