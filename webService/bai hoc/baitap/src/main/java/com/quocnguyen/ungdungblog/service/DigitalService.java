package com.quocnguyen.ungdungblog.service;

import com.quocnguyen.ungdungblog.entity.Digital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DigitalService {
    Page<Digital> findAll(Pageable pageable);
    List<Digital> findAll();
    Digital findById(Integer id);
    void save(Digital digital);
    void delete(Digital digital);
    List<Digital> findById_Category(Integer id);
    List<Digital> findByTitle(String Author);
    List<Digital> findAllByLoadMore(int start,int limit);
}
