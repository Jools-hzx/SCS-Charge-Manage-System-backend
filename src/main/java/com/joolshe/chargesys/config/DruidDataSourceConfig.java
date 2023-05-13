package com.joolshe.chargesys.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Zexi He.
 * @date 2023/5/13 17:08
 * @description:    将数据源替换成德鲁伊
 */
@Configuration
@Slf4j
public class DruidDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datatsource")
    public DataSource configDruidSource() {
        DruidDataSource dataSource = new DruidDataSource();
        log.info("加载数据源:" + dataSource.getClass());
        return dataSource;
    }
}
