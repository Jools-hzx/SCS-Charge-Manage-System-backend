package com.joolshe.chargesys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joolshe.chargesys.bean.User;

import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/16 22:08
 * @description:
 */
public interface UserService extends IService<User> {


    void addBatchUsers(List<User> users);
}
