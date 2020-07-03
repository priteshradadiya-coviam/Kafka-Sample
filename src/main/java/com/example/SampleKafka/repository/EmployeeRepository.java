package com.example.SampleKafka.repository;

import com.example.SampleKafka.entity.EmployeeData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeData,String> {
}
