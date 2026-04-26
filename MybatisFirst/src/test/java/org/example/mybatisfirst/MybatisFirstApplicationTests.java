package org.example.mybatisfirst;

import org.example.mybatisfirst.dao.UserMapper;
import org.example.mybatisfirst.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisFirstApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testUserMapper(){
        List<User> userList = userMapper.getUserList();
        userList.forEach(System.out::println);
    }

}
