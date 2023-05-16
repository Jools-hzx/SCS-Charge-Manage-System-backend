package com.joolshe.chargesys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joolshe.chargesys.bean.Charger;

/**
 * @author Zexi He.
 * @date 2023/5/14 16:13
 * @description:
 */
public interface ChargerService extends IService<Charger> {

    boolean updateStatus(Charger charger);
}
