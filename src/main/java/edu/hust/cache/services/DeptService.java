package edu.hust.cache.services;

import edu.hust.cache.bean.Department;
import edu.hust.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dpet")
    public Department getDetpById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDetpById(id);
        return department;
    }
}
