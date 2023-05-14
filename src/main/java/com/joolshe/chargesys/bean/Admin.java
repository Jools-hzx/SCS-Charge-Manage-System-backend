package com.joolshe.chargesys.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zexi He.
 * @date 2023/5/13 23:32
 * @description:    管理员用户的 bean 对象
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    private Integer id;
    private String name;
    private String password;

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
