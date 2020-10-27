package com.quocnguyen.giohang.service.impl;

import com.quocnguyen.giohang.dto.PaginatesDto;
import com.quocnguyen.giohang.service.PaginatesService;
import org.springframework.stereotype.Service;

@Service
public class PaginatesServiceImpl implements PaginatesService {
    @Override
    public PaginatesDto getInfoPaginates(int totalData, int limit, int currentPage) {
        PaginatesDto paginatesDto = new PaginatesDto();
        paginatesDto.setTotalPage(setInfoTotalPage(totalData, limit));
        paginatesDto.setLimit(limit);
        paginatesDto.setCurrentPage(checkCurrentPage(currentPage, paginatesDto.getTotalPage()));
        int start = findStart(paginatesDto.getCurrentPage(), limit);
        paginatesDto.setStart(start);
        int end = findEnd(paginatesDto.getStart(), limit, totalData);
        paginatesDto.setEnd(end);
        return paginatesDto;
    }

    private int findEnd(int start, int limit, int totalData) {
        return start + limit > totalData ? totalData : (start + limit) - 1;
    }

    private int findStart(int currentPage, int limit) {
        return ((currentPage - 1) * limit) + 1;
    }

    public int setInfoTotalPage(int totalData, int limit) {
        int totalPage = 0;
        totalPage = totalData / limit;
        totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
        return totalPage;
    }

    public int checkCurrentPage(int currentPage, int totalPage) {
        if (currentPage < 1) {
            return 1;
        }
        if (currentPage > totalPage) {
            return totalPage;
        }
        return currentPage;
    }
}
