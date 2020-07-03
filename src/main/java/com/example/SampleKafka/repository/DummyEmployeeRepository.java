package com.example.SampleKafka.repository;

import com.example.SampleKafka.entity.DummyEmployeeData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyEmployeeRepository extends CrudRepository<DummyEmployeeData,String> {
}
