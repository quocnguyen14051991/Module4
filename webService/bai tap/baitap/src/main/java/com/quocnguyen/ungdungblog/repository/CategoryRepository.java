package com.quocnguyen.ungdungblog.repository;

import com.quocnguyen.ungdungblog.entity.Category;
import com.quocnguyen.ungdungblog.entity.Digital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
