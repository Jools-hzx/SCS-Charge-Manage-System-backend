package com.joolshe.chargesys.controller;

import com.joolshe.chargesys.bean.Result;
import com.joolshe.chargesys.bean.Station;
import com.joolshe.chargesys.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:31
 * @description:    Station bean 类对应的 Controller 对象
 */

@RequestMapping("/stations")
@Controller
@Slf4j
public class StationController {

    @Resource
    private StationService stationService;

    @GetMapping("/list")
    @ResponseBody
    public Result<?> listAll() {
        try {
            List<Station> data = stationService.list();
            log.info("请求显示数据量:{}", data.size());
            return Result.success("请求成功", data);
        } catch (Exception e) {
            return Result.error("server", "请求失败");
        }
    }
}
