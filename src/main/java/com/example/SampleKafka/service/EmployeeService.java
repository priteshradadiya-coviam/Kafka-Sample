package com.example.SampleKafka.service;

import com.example.SampleKafka.dto.EmployeeDTO;
import com.example.SampleKafka.entity.DummyEmployeeData;

public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);
}
