package com.example.SampleKafka.service.serviceImpl;
import com.example.SampleKafka.dto.EmployeeDTO;
import com.example.SampleKafka.entity.EmployeeData;
import com.example.SampleKafka.repository.EmployeeRepository;
import com.example.SampleKafka.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        EmployeeData employee = new EmployeeData();
        BeanUtils.copyProperties(employeeDTO, employee);
        String employeeId = employeeRepository.save(employee).getEmployeeId();
        return employeeId;
    }
}
