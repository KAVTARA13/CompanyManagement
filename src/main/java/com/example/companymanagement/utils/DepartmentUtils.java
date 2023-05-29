package com.example.companymanagement.utils;

import com.example.companymanagement.dtos.DepartmentDto;
import com.example.companymanagement.models.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentUtils {
    private static DepartmentUtils departmentUtils;
    private List<Department> departmentList;

    private DepartmentUtils(){
        departmentList = new ArrayList<>();
    }

    public static DepartmentUtils getInstance(){
        if (departmentUtils == null){
            departmentUtils = new DepartmentUtils();
        }
        return departmentUtils;
    }

    public Long generateId() {
        int size = this.departmentList.size();
        if (size==0){
            return 1L;
        }
        return this.departmentList.get(size-1).getId()+1;
    }
    public Boolean addDepartment(Department department){
        return this.departmentList.add(department);
    }

    public List<Department> getDepartments() {
        return this.departmentList;
    }

    public Object deleteDepartment(Long id) {
        Department department = this.departmentList.stream().filter(i->i.getId().equals(id)).findAny().orElse(null);
        if (department != null){
            this.departmentList.remove(department);
        }
        return department;
    }

    public Object editDepartment(Long id, DepartmentDto dto) {
        Department department = this.departmentList.stream().filter(i->i.getId().equals(id)).findAny().orElse(null);
        if (department != null){
            department.setName(dto.getName());
            department.setHead(dto.getHead());
        }
        return department;
    }

    public Department findByName(String name) {
        return this.departmentList.stream()
                .filter(c -> c.getName().contains(name))
                .findAny()
                .orElse(null);
    }
}
