package com.sallu.socialmediaapplication.rest;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sallu.socialmediaapplication.entity.Employee;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    static List<Employee> list;

    static {
        list = new ArrayList<>();
        list.add(new Employee(1, "apple", "123"));
        list.add(new Employee(2, "banana", "234"));
        list.add(new Employee(3, "carrot", "5234"));
    }

    @GetMapping
    public MappingJacksonValue getEmployee() {
        MappingJacksonValue jacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("employeePassword");
        FilterProvider provider = new SimpleFilterProvider().addFilter("Employee-filter", filter);

        jacksonValue.setFilters(provider);
        return jacksonValue;
    }

    @GetMapping("/full")
    public MappingJacksonValue getFullEmployee() {
        MappingJacksonValue jacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter1 = SimpleBeanPropertyFilter.filterOutAllExcept("employeeId", "employeeName", "employeePassword");

        FilterProvider provider = new SimpleFilterProvider().addFilter("Employee-filter", filter1);
        jacksonValue.setFilters(provider);

        return jacksonValue;
    }
}
