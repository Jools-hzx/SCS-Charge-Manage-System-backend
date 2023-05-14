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
}
