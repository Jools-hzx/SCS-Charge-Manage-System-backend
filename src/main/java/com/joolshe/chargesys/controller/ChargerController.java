package com.joolshe.chargesys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolshe.chargesys.bean.Charger;
import com.joolshe.chargesys.bean.Result;
import com.joolshe.chargesys.service.ChargerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/14 16:18
 * @description:
 */

@Controller
@Slf4j
@RequestMapping("/chargers")
public class ChargerController {

    @Resource
    private ChargerService chargerService;

    @GetMapping("/list")
    @ResponseBody
    public Result<?> listChargers() {
        List<Charger> data = chargerService.list();
        if (data.size() == 0) {
            log.warn("当前数据库中无charger数据，或者查询数据库失败");
        }
        return Result.success("查询成功", data);
    }

    //该方法完成分页查询charger信息
    @GetMapping("/queryPage")
    @ResponseBody
    public Result<?> queryPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                               @RequestParam(value = "chargerId", defaultValue = "") String id,
                               @RequestParam(value = "stationId", defaultValue = "") String stationId) {

        //使用 LambdaQueryWrapper 完成分页查询
        LambdaQueryWrapper<Charger> queryWrapper = Wrappers.lambdaQuery();

        //如果 chargeId不为空，根据stationId查询该站点内的所有 charger
        if (StringUtils.hasText(stationId)) {
            //SFunction<Station, String> sf = Station::getName;
            //queryWrapper.like(sf, search);
            //简写
            queryWrapper.like(Charger::getStationId, stationId);
        }

        //如果 chargeId不为空，根据id查询charger
        if (StringUtils.hasText(id)) {
            queryWrapper.like(Charger::getId, id);
        }

        //如果都不为空，合并查找

        Page<Charger> page = chargerService.page(new Page<>(pageNum, pageSize), queryWrapper);
        return Result.success("查询成功", page);
    }

}
