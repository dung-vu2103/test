package com.example.demo.Repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = """
            select * from book where (:id is null or id=:id)
            """, nativeQuery = true)
    List<Book> search1(@Param("id") Integer id);
    @Modifying
    @Query(value = """
            update book set name = :name where id = :id
            """, nativeQuery = true)
    void upBook(@Param("id") Integer id, @Param("name") String name);
    @Modifying
    @Query(value = """
           delete from book where id=:id
            """, nativeQuery = true)
    void delete(@Param("id") Integer id);
}
