package com.joolshe.chargesys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.joolshe.chargesys.bean.Admin;
import com.joolshe.chargesys.bean.Result;
import com.joolshe.chargesys.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Zexi He.
 * @date 2023/5/13 23:53
 * @description:
 */
@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    //自动装配 Service
    @Resource
    private AdminService adminService;

    @PostMapping("/login")
    @ResponseBody
    public Result adminLogin(@RequestBody Admin admin) {

        log.info("post param:{}", admin);

        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();

        Map<String, String> wrapperMap = new HashMap<>();
        wrapperMap.put("name", admin.getName());
        wrapperMap.put("password", admin.getPassword());

        try {
            adminQueryWrapper = adminQueryWrapper.allEq(wrapperMap);
            Admin validAdmin = adminService.getOne(adminQueryWrapper);
            //如果查询到管理员用户，则说明登录成功
            if (validAdmin != null) {
                log.info("管理员登录:" + admin);
                return Result.success("登陆成功");
            }
            return Result.error("client", "登陆失败，请检查用户名或密码");
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.error("server", "服务端出错");
        }
    }
}
