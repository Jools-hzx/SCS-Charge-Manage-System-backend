package com.joolshe.chargesys.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author Zexi He.
 * @date 2023/5/16 22:02
 * @description:
 *
 * CREATE TABLE `user` (
 *  `id` INT PRIMARY KEY AUTO_INCREMENT,	-- 用户 id
 *  `username` VARCHAR( 32 ) NOT NULL UNIQUE, -- 用户名
 *  `password` VARCHAR( 32 ) NOT NULL,	-- 用户密码
 *  `email` VARCHAR( 64 ),			-- 电子邮箱
 *  `phone` VARCHAR( 20 ),			-- 手机号码
 *  `balance` DECIMAL(11, 2) NOT NULL DEFAULT 0.0	-- 账户余额
 * )CHARSET=utf8;
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotEmpty(message = "用户名称不能为空")
    private String username;

    @NotEmpty(message = "运营商不能为空")
    private String password;

    @NotEmpty(message = "电子邮箱不能为空")
    private String email;

    @NotEmpty(message = "手机号码不能为空")
    private String phone;

    @NotNull(message = "余额不能为空")
    private BigDecimal balance;

}
