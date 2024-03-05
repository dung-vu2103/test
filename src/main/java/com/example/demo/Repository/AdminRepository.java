package com.example.demo.Repository;

import com.example.demo.Dto.AdminDto;
import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Modifying
    @Query(value = """
         insert into admin(admin_name, ten) values (:admin_name, :ten)
         """, nativeQuery = true)
    void create(@Param("admin_name") String adminName, @Param("ten") String ten);

    @Modifying
    @Query(value = """
            update admin set admin_name=:admin_name,ten=:ten where id=:id
            """, nativeQuery = true)
    void update1(@Param("id") Integer id,@Param("admin_name") String adminname,@Param("ten") String ten);
 @Modifying
    @Query(value = """
           delete from admin where id=:id
            """, nativeQuery = true)
    void delete(@Param("id") Integer id);

}
