package com.joolshe.chargesys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joolshe.chargesys.bean.Station;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:19
 * @description:    Station bean 对应的 mapper
 */

@Mapper
public interface StationMapper extends BaseMapper<Station> {
}
