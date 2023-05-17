package com.joolshe.chargesys;

import com.joolshe.chargesys.bean.Admin;
import com.joolshe.chargesys.controller.AdminController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Zexi He.
 * @date 2023/5/14 0:09
 * @description:
 */

@SpringBootTest
public class AdminControllerTest {

    @Resource
    private AdminController adminController;

    @Test
    public void queryAdminByNameAndPwdTest() {
//        adminController.adminLogin(new Admin("Jools_He", "hzx"), HttpSession session);
    }
}
