package com.quocnguyen.giohang.service;

import com.quocnguyen.giohang.dto.PaginatesDto;

public interface PaginatesService {
    PaginatesDto getInfoPaginates(int totalData,int limit,int currentPage);
}
