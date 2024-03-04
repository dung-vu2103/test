package com.example.demo.Repository;

import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    @Query(value = """
            select * from admin where (:id is null or id=:id)
            """, nativeQuery = true)
    List<Admin> search(@Param("id") Integer id);
    @Query(value = """
            insert into admin(name,ten) values (:name,:ten)
            """, nativeQuery = true)
    void create(@Param("name") String name,@Param("ten") String ten);
    @Query(value = """
            update admin set name=:name,ten=:ten where id=:id
            """, nativeQuery = true)
    void update1(@Param("id") Integer id,@Param("name") String name,@Param("ten") String ten);
    @Query(value = """
           delete from admin where id=:id
            """, nativeQuery = true)
    void delete(@Param("id") Integer id);

}
