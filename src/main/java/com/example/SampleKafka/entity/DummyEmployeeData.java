package com.example.SampleKafka.entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DummyEmployee")
@Getter
@Setter
public class DummyEmployeeData {
    @Id
    String employeeId;
    String employeeName;
    String salary;
    String department;
}
