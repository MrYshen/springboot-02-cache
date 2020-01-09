package edu.hust.cache.services;

import edu.hust.cache.bean.Employee;
import edu.hust.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 开启缓存
     * @param id
     * @return
     */
    @Cacheable(cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    /**
     * @CachePut:及调用方法，又更新缓存数据；
     * 修改了数据库的某个数据，同时更新缓存；
     * 更新前与更新后的key不同，虽然数据都放到了缓存池中但是key不一样，所以查询emp/id还是原值 未更新
     * 需要将key值锁定为#employee.id或result.id
     */
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp:"+employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }
}
