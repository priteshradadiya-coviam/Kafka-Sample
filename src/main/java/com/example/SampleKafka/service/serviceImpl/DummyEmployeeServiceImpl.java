package com.example.SampleKafka.service.serviceImpl;

import com.example.SampleKafka.entity.DummyEmployeeData;
import com.example.SampleKafka.repository.DummyEmployeeRepository;
import com.example.SampleKafka.service.DummyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyEmployeeServiceImpl implements DummyEmployeeService {

    @Autowired
    DummyEmployeeRepository dummyEmployeeRepository;

    @Override
    public Iterable<DummyEmployeeData> saveEmployee(DummyEmployeeData dummyEmployeeData) {
        dummyEmployeeRepository.save(dummyEmployeeData);
        return dummyEmployeeRepository.findAll();
    }
}
