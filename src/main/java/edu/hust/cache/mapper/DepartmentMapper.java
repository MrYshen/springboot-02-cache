package edu.hust.cache.mapper;

import edu.hust.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department WHERE id= #{id}")
    public Department getDetpById(Integer id);
}
