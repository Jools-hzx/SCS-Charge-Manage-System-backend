package com.joolshe.chargesys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joolshe.chargesys.bean.Station;
import com.joolshe.chargesys.mapper.StationMapper;
import com.joolshe.chargesys.service.StationService;
import org.springframework.stereotype.Service;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:21
 * @description:
 */
@Service
public class StationServiceImpl
        extends ServiceImpl<StationMapper, Station>
        implements StationService {
}
