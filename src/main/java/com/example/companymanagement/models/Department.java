package com.example.companymanagement.models;

import com.example.companymanagement.dtos.DepartmentDto;
import com.example.companymanagement.utils.DepartmentUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Data
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;
    private String head;

    public Department (DepartmentDto dto){
        this.id = DepartmentUtils.getInstance().generateId();
        this.name = dto.getName();
        this.head = dto.getHead();
    }
}
