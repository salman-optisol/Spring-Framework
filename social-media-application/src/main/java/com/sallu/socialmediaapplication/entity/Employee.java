package com.sallu.socialmediaapplication.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

@Data
@JsonFilter("Employee-filter")
public class Employee {

    private int employeeId;
    private String employeeName;
    private String employeePassword;

    public Employee(int employeeId, String employeeName, String employeePassword) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePassword = employeePassword;
    }
}
