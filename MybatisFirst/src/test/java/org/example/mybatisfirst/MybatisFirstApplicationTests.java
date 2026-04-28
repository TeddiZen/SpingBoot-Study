package org.example.mybatisfirst;

import org.example.mybatisfirst.dao.UserMapper;
import org.example.mybatisfirst.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
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

    @Test
    void testAddList(){
        User user = new User("10086", "冯丽", 29, "女", "市场部", "品牌专员", "本科", "2022-02-14", new Date().toString(), "13611223310");
        userMapper.add(user);
    }

    @Test
    void updateList (){
        userMapper.update("10086", "回家部门", "回家", new Date().toString());
    }

    @Test
    void delList (){
        int delUser = userMapper.del("10086");
        System.out.println("Deletde-----" + delUser);
    }

    @Test
    void searchUser(){
        User user = userMapper.getUser("4");
        System.out.println(user);
    }

    @Test
    void searchId(){
        User user = userMapper.searchById("8");
        System.out.println(user);
    }
}
