package com.joolshe.chargesys.service;

import com.joolshe.chargesys.bean.Charger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/14 16:15
 * @description:
 */

@SpringBootTest
public class ChargerServiceTest {

    @Resource
    private ChargerService chargerService;

    @Test
    public void listAllTest() {
        List<Charger> list = chargerService.list();
        for (Charger charger : list) {
            System.out.println(charger);
        }
    }

    @Test
    public void updateChargerStatusFromAvilToUse() {
        Charger charger = new Charger();
        charger.setId(29);
        charger.setStatus(1);
        charger.setStationId(21);

        boolean succeed = chargerService.updateStatus(charger);
        if (succeed) {
            System.out.println("更新状态成功！");
        } else {
            System.out.println("更新状态失败！");
        }
    }

    @Test
    public void updateChargerStatusFromUseToAvail() {
        Charger charger = new Charger();
        charger.setId(29);
        charger.setStatus(0);
        charger.setStationId(21);

        boolean succeed = chargerService.updateStatus(charger);
        if (succeed) {
            System.out.println("更新状态成功！");
        } else {
            System.out.println("更新状态失败！");
        }
    }

    @Test
    public void updateChargerStatusFromUseToError() {
        Charger charger = new Charger();
        charger.setId(29);
        charger.setStatus(2);
        charger.setStationId(21);

        boolean succeed = chargerService.updateStatus(charger);
        if (succeed) {
            System.out.println("更新状态成功！");
        } else {
            System.out.println("更新状态失败！");
        }
    }

}
