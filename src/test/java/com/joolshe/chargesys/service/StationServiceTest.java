package com.joolshe.chargesys.service;

import com.joolshe.chargesys.bean.Station;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:22
 * @description:    StationService 对应的测试类
 */

@SpringBootTest
public class StationServiceTest {

    @Resource
    private StationService stationService;

    @Test
    public void listStationsTest() {
        List<Station> list = stationService.list();
        if (list != null) {
            for (Station station : list) {
                System.out.println(station);
            }
        }
    }
}
