package com.joolshe.chargesys.service;

import com.joolshe.chargesys.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/16 22:15
 * @description:    测试 UserService
 */

@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void addUsersTest() {

        List<User> userList = new ArrayList<>();

        BigDecimal baseValue = BigDecimal.valueOf(10.0);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("Franck-Jools" + i);
            user.setEmail("Franck-Jools" + i + "@qq.com");
            user.setPassword("123456" + i);
            user.setPhone("136025590" + i);
            user.setBalance(baseValue.add(BigDecimal.valueOf(i)));
            userList.add(user);
        }

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("Wakko-Jools" + i);
            user.setEmail("Wakoo-Jools" + i + "@qq.com");
            user.setPassword("778877" + i);
            user.setPhone("1321932090" + i);
            user.setBalance(baseValue.add(BigDecimal.valueOf(10 * i)));
            userList.add(user);
        }

        userService.addBatchUsers(userList);

        System.out.println("添加成功，成功添加数据: " +userList.size());
    }
}
