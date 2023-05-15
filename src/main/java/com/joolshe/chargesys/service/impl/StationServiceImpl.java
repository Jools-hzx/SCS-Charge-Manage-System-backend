package com.joolshe.chargesys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joolshe.chargesys.bean.Charger;
import com.joolshe.chargesys.bean.Station;
import com.joolshe.chargesys.mapper.ChargerMapper;
import com.joolshe.chargesys.mapper.StationMapper;
import com.joolshe.chargesys.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:21
 * @description:
 */
@Service
@Slf4j
public class StationServiceImpl
        extends ServiceImpl<StationMapper, Station>
        implements StationService {

    @Resource
    private StationMapper stationMapper;

    @Resource
    private ChargerMapper chargerMapper;

    /**
     * 该方法用于注册站点，同时将该站点对应的充电桩信息加入到数据库中
     *
     * @param station 待添加的站点
     */
    @Transactional(timeout = 5)
    @Override
    public void saveStation(Station station) {

        Integer totalCharger = station.getTotalCharger();

        //自定义方法 返回添加站点的 Id
        stationMapper.addStation(station);
        log.info("添加的站点的对应 id:{}", station.getId());


        //根据该站点的站点名和位置信息查询该站点的id
        Integer stationId = station.getId();

        //批量插入 chargers
        List<Charger> chargers = new ArrayList<>();
        for (int i = 0; i < totalCharger; i++) {
            chargers.add(new Charger(null, 0, stationId));
        }
        //自定义方法 批量插入 charger entity
        chargerMapper.insertBatch(chargers);
    }

    /**
     * 该方法注销站点，同时删除数据库中所有的充电桩信息
     *
     * @param id 待删除的充电站点 id
     * @return true 表示删除成功，false 表示删除失败
     */
    @Transactional(timeout = 5)
    @Override
    public boolean delStation(Integer id) {

        //删除站点
        int sRow = stationMapper.deleteById(id);

        Map<String, Object> map = new HashMap<>();
        map.put("station_Id", id);
        int aRow = chargerMapper.deleteByMap(map);

        return sRow != 0;
    }
}
