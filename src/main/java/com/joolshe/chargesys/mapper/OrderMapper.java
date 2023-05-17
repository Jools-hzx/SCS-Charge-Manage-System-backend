package com.joolshe.chargesys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joolshe.chargesys.bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/17 11:14
 * @description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    void insertBatch(List<Order> orders);
}
