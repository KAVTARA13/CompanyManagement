package com.example.companymanagement.services.impl;

import com.example.companymanagement.dtos.ApiResponse;
import com.example.companymanagement.dtos.DepartmentDto;
import com.example.companymanagement.models.Department;
import com.example.companymanagement.services.IDepartmentService;
import com.example.companymanagement.utils.DepartmentUtils;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService implements IDepartmentService {
    private DepartmentUtils departmentUtils = DepartmentUtils.getInstance();
    @Override
    public ApiResponse add(DepartmentDto dto) {
        if (dto == null){
            return new ApiResponse().addError("INCORRECT_PARAM","DEPARTMENT_DTO_IS_NULL");
        }
        return new ApiResponse("status",this.departmentUtils.addDepartment(new Department(dto)));
    }

    @Override
    public ApiResponse delete(Long id) {
        if(id==null || id <= 0){
            return new ApiResponse().addError("id", "incorrect value");
        }
        return new ApiResponse("department",this.departmentUtils.deleteDepartment(id));
    }

    @Override
    public ApiResponse edit(Long id, DepartmentDto dto) {
        if (id == null || id <= 0){
            return new ApiResponse().addError("id","incorrect value");
        }
        if (dto != null){
            return new ApiResponse("department",this.departmentUtils.editDepartment(id,dto));
        }
        return new ApiResponse().addError("INCORRECT_PARAM", "INCORRECT_PARAM");
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("departments",departmentUtils.getDepartments());
    }

    @Override
    public ApiResponse searchByName(DepartmentDto dto) {
        if (dto == null || dto.getName() == null) {
            return new ApiResponse().addError("name", "not found");
        }
        Department department = departmentUtils.findByName(dto.getName());
        if (department == null) {
            return new ApiResponse().addError("department", "not found");
        }
        return new ApiResponse("department", department);
    }
}
