package com.joolshe.chargesys.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.joolshe.chargesys.bean.Charger;
import com.joolshe.chargesys.bean.Station;
import com.joolshe.chargesys.mapper.ChargerMapper;
import com.joolshe.chargesys.mapper.StationMapper;
import com.joolshe.chargesys.service.ChargerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Zexi He.
 * @date 2023/5/14 16:14
 * @description:
 */
@Service
@Slf4j
public class ChargerServiceImpl
        extends ServiceImpl<ChargerMapper, Charger>
        implements ChargerService {

    @Resource
    private StationMapper stationMapper;

    @Resource
    private ChargerMapper chargerMapper;


    /**
     * 该方法完成充电桩状态更新;同时更新站点内的可用桩数目
     *
     * @param charger 更新的 entity
     * @return true 表示更新成功
     */
    @Transactional
    @Override
    public boolean updateStatus(Charger charger) {

        //获取更新的 Charger 信息
        Integer chargerId = charger.getId();
        Integer stationId = charger.getStationId();
        Integer status = charger.getStatus();

        //获取 Charger 原始的信息
        Charger preCharger = chargerMapper.selectById(chargerId);
        Integer preStatus = preCharger.getStatus();

        //更新
        chargerMapper.updateById(charger);

        //获取该Charger所在站点的原始信息
        Station station = stationMapper.selectById(stationId);
        Integer availCharger = station.getAvailableCharger();

        UpdateWrapper<Station> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", stationId);

        //如果原始状态为 "空闲中"， 当更新为 "占用中" 或者 "故障中" 需要更新可用桩数目
        if (preStatus == 0 && (status == 1 || status == 2)) {
            station.setAvailableCharger(availCharger - 1);
            stationMapper.update(station, updateWrapper);
            log.info("更新充电站点, id: {}; 可用桩数目: {}", stationId, availCharger - 1);
        } else if (preStatus != 0 && status == 0) {
            //如果原始状态为 "占用中" 或者 "故障中"， 当更新为 "空闲中" 需要更新可用桩数目
            station.setAvailableCharger(availCharger + 1);
            stationMapper.update(station, updateWrapper);
            log.info("更新充电站点, id: {}; 可用桩数目: {}", stationId, availCharger + 1);
        }

        log.info("充电桩状态信息更新, Charger: {}", charger);
        return true;
    }

}
