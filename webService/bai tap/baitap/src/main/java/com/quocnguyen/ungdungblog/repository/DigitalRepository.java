package com.quocnguyen.ungdungblog.repository;

import com.quocnguyen.ungdungblog.entity.Digital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DigitalRepository extends JpaRepository<Digital,Integer> {
    @Query(value = "select * from digital_blog where category_id=?1", nativeQuery = true)
    List<Digital> searchByIdCategory(Integer id);
}
