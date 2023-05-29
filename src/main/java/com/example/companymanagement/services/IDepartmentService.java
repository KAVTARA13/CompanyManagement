package com.example.companymanagement.services;

import com.example.companymanagement.dtos.ApiResponse;
import com.example.companymanagement.dtos.DepartmentDto;

public interface IDepartmentService {
    ApiResponse add(DepartmentDto dto);
    ApiResponse delete(Long id);
    ApiResponse edit(Long id,DepartmentDto dto);
    ApiResponse getAll();

    ApiResponse searchByName(DepartmentDto dto);
}
