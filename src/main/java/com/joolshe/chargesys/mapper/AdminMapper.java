package com.joolshe.chargesys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joolshe.chargesys.bean.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Zexi He.
 * @date 2023/5/13 23:40
 * @description:    Admin bean类对应的 Mapper
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
