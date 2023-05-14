package com.joolshe.chargesys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joolshe.chargesys.bean.Charger;
import com.joolshe.chargesys.mapper.ChargerMapper;
import com.joolshe.chargesys.service.ChargerService;
import org.springframework.stereotype.Service;

/**
 * @author Zexi He.
 * @date 2023/5/14 16:14
 * @description:
 */
@Service
public class ChargerServiceImpl
        extends ServiceImpl<ChargerMapper, Charger>
        implements ChargerService {
}
