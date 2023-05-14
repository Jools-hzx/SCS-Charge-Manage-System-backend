package com.joolshe.chargesys.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joolshe.chargesys.bean.Admin;
import com.joolshe.chargesys.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
 * @author Zexi He.
 * @date 2023/5/13 23:43
 * @description:
 */
@Service
public class AdminServiceImpl
        extends ServiceImpl<AdminMapper, Admin>
        implements AdminService {

}
