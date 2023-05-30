package com.example.companymanagement.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Entity
@Table(name = "EMPLOYEES")
public class Employee extends BaseEntity<Long>{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "employeeIdSeq",sequenceName = "EMPLOYEE_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "employeeIdSeq")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "SALARY")
    private Integer salary;

    @ManyToOne
    private Department department;
}
