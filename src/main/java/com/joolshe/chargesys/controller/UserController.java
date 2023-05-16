package com.joolshe.chargesys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolshe.chargesys.bean.Result;
import com.joolshe.chargesys.bean.User;
import com.joolshe.chargesys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Zexi He.
 * @date 2023/5/16 22:31
 * @description:    User 对应的 Controller
 */
@Controller
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/listUsersByPage")
    @ResponseBody
    public Result<?> queryUsersPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {

        try {
            Page<User> page = userService.page(new Page<>(pageNum, pageSize));
            return Result.success("查询成功", page);
        } catch (Exception e) {
            log.error("查询分页 User 数据出错");
            return Result.error("server", e.getMessage());
        }
    }
}
