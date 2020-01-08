package edu.hust.cache.services;

import edu.hust.cache.bean.Employee;
import edu.hust.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }
}
