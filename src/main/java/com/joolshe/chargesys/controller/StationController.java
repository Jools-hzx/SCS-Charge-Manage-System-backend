package com.joolshe.chargesys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joolshe.chargesys.bean.Result;
import com.joolshe.chargesys.bean.Station;
import com.joolshe.chargesys.service.StationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:31
 * @description: Station bean 类对应的 Controller 对象
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


    //该方法用于注册站点
    @PostMapping("/save")
    @ResponseBody
    public Result<?> saveStation(@RequestBody Station station) {

        //TODO 增加站点添加的后端校验
        if (station.getAvailableCharger() == null) {
            //初始状态下，站点的可用桩数目即为总桩数
            station.setAvailableCharger(station.getTotalCharger());
        }

        try {
            //调用自定义的注册站点方法，注册站点的同时注册该站点内的充电桩
            stationService.saveStation(station);
            return Result.success("成功");
        } catch (Exception e) {
            log.error("注册站点失败: {}", e.getMessage());
            return Result.error("server", "添加失败,请检查录入的信息");
        }
    }

    //该方法用于通过id查询数据，回显给前端表单
    @GetMapping("/queryById/{id}")
    @ResponseBody
    public Result<?> queryById(@PathVariable("id") Integer id) {
        try {
            Station station = stationService.getById(id);
            return Result.success("", station);
        } catch (Exception e) {
            log.error("查询站点信息失败:{}", e.getMessage());
            return Result.error("server", "?");
        }
    }

    //该方法用于更新站点
    @PutMapping("/update")
    @ResponseBody
    public Result<?> updateStation(@RequestBody Station station) {
        //注解存在更新记录，否插入一条记录
        try {
            boolean saved = stationService.saveOrUpdate(station);
            if (saved) {
                return Result.success("更新成功");
            } else {
                return Result.error("server", "更新失败");
            }
        } catch (Exception e) {
            log.error("更新站点信息失败:{}", e.getMessage());
            return Result.error("server", "更新失败");
        }
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Result<?> delStation(@PathVariable("id") Integer id) {
        try {
            boolean deleted = stationService.delStation(id);
            if (deleted) {
                return Result.success("删除成功！");
            } else {
                return Result.error("server", "删除失败");
            }
        } catch (Exception e) {
            log.error("删除站点失败:{}", e.getMessage());
            return Result.error("server", "删除失败");
        }
    }

    /**
     * 该方法完成请求分页数据
     *
     * @param pageNum  页数
     * @param pageSize 页码
     * @return 分页数据
     */
    @GetMapping("/listByPage")
    @ResponseBody
    public Result<?> listByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {

        try {
            Page<Station> page = stationService.page(new Page<>(pageNum, pageSize));
            return Result.success("", page);
        } catch (Exception e) {
            log.error("查询出错:{}", e.getMessage());
            return Result.error("server", "请求失败");
        }
    }
}
