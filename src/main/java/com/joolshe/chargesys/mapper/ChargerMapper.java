package com.joolshe.chargesys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joolshe.chargesys.bean.Charger;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/14 16:12
 * @description: Charger 对应的 Mapper 类
 */

@Mapper
public interface ChargerMapper extends BaseMapper<Charger> {

    void insertBatch(List<Charger> chargers);
}
