package com.joolshe.chargesys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joolshe.chargesys.bean.User;
import com.joolshe.chargesys.mapper.UserMapper;
import com.joolshe.chargesys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/16 22:09
 * @description:
 */

@Slf4j
@Service
public class UserServiceImpl
        extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addBatchUsers(List<User> users) {
        userMapper.insertBatch(users);
        log.info("批量添加user成功");
    }
}
