package edu.hust.cache.mapper;

import edu.hust.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id =#{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee SET email=#{email},lastName=#{lastName},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee WHERH id = #{id}")
    public void deleteEmpById(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) VALUES(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmployee(Employee employee);
}
