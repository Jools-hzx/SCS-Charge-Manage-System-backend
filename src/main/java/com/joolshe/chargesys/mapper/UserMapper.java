package com.joolshe.chargesys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joolshe.chargesys.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/16 22:07
 * @description:    User bean 类的 mapper 层
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    void insertBatch(List<User> chargers);
}
