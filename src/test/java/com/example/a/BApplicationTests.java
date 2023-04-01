package com.example.a;

import com.example.a.mapper.CourseMapper;
import com.example.a.pojo.User;
import com.example.a.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BApplicationTests {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private CourseMapper courseMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void testDatabase() {
        registerService.register(new User("cc", "ll", "22"));
    }

    @Test
    void testDatabase1() {
        System.out.println(courseMapper.selectById("11"));
    }
}
