package com.example.a;

import com.example.a.pojo.User;
import com.example.a.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BApplicationTests {
    @Autowired
    private RegisterService registerService;
    @Test
    void contextLoads() {
    }

    @Test
    void testDatabase() {
        registerService.register(new User("ll", "ll", "22"));
    }
}
