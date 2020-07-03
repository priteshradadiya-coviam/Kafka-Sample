package com.example.SampleKafka.service;

import com.example.SampleKafka.entity.DummyEmployeeData;

public interface DummyEmployeeService {
    Iterable<DummyEmployeeData> saveEmployee(DummyEmployeeData dummyEmployeeData);
}
