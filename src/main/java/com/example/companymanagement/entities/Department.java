package com.example.companymanagement.entities;

import com.example.companymanagement.dtos.DepartmentDto;
import com.example.companymanagement.utils.DepartmentUtils;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "DEPARTMENT")
public class Department  extends BaseEntity<Long>{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "departmentIdSeq",sequenceName = "DEPARTMENT_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "departmentIdSeq")
    private Long id;

    @Column(name = "NAME",nullable = false,updatable = true,insertable = true)
    private String name;
    @Column(name = "HEAD")
    private String head;

    public Department (DepartmentDto dto){
        this.name = dto.getName();
        this.head = dto.getHead();
    }
}
