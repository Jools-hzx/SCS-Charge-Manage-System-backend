package com.joolshe.chargesys.controller;

import com.joolshe.chargesys.bean.Charger;
import com.joolshe.chargesys.bean.Result;
import com.joolshe.chargesys.service.ChargerService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
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

}
