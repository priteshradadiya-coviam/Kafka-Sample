package com.example.SampleKafka.controller;

import com.example.SampleKafka.dto.EmployeeDTO;
import com.example.SampleKafka.entity.DummyEmployeeData;
import com.example.SampleKafka.entity.EmployeeData;
import com.example.SampleKafka.service.DummyEmployeeService;
import com.example.SampleKafka.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping
public class Employee {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "kafkaAdd";

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DummyEmployeeService dummyEmployeeService;

    @PostMapping("/addEmployee")
    String addEmployee(@RequestBody EmployeeDTO employeeDTO) throws JsonProcessingException {
        String response=employeeService.addEmployee(employeeDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeData employeeData = new EmployeeData();
        BeanUtils.copyProperties(employeeDTO, employeeData);
        employeeData.setEmployeeId(response);
        kafkaTemplate.send(TOPIC, objectMapper.writeValueAsString(employeeData));
        return "{\"response\":\""+response+"\"}";
    }

    @KafkaListener(topics = "kafkaAdd",groupId = "group_id")
    public Iterable<DummyEmployeeData> save(String employeeData) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        DummyEmployeeData dummyEmployeeData = new DummyEmployeeData();
        dummyEmployeeData = objectMapper.readValue(employeeData,DummyEmployeeData.class);
        return  (dummyEmployeeService.saveEmployee(dummyEmployeeData));
    }
}
