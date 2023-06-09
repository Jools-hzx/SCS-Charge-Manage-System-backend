package com.joolshe.chargesys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joolshe.chargesys.bean.Station;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:20
 * @description:
 */
public interface StationService extends IService<Station> {

    //自定义添加站点方法
    void saveStation(Station station);

    boolean delStation(Integer id);
}
