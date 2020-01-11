package edu.hust.cache;

import edu.hust.cache.bean.Employee;
import edu.hust.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot01CacheApplicationTests {

    @Resource
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;//操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象的

    /**
     * String、List、Set、Hash、Zset(有序集合)
     * stringRedisTemplate.opsForValue();操作字符串的
     * stringRedisTemplate.opsForList();操作列表的
     */
    @Test
    public void test01(){
//        //给redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg", "hello");
        String s = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(s);
//        stringRedisTemplate.opsForList().leftPush("mylist", "a");
//        stringRedisTemplate.opsForList().leftPush("mylist", "b");

    }

    @Test
    public void test02(){
        Employee employee = employeeMapper.getEmpById(1);
        redisTemplate.opsForValue().set("emp"+"-01", employee);
    }

    @Test
    void contextLoads() {
//        Employee employee = employeeMapper.getEmpById(1);
//        System.out.println(employee);
    }

}
