package com.example.demo.Service;

import com.example.demo.Dto.BookDto;
import com.example.demo.Repository.BookRepository;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImp implements  BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<BookDto> get(Integer id) {
        List<Book> bookList=bookRepository.search1(id);
        List<BookDto> bookDtos=new ArrayList<>();
        for(Book book:bookList){
            bookDtos.add(new BookDto(book.getId(),book.getName()));
        }
        return bookDtos;
    }

    @Override
    public void up(Integer id,String name) {
        bookRepository.upBook(id,name);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.delete(id);
    }
}
