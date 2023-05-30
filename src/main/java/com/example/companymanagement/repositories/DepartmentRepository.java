package com.example.companymanagement.repositories;

import com.example.companymanagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
