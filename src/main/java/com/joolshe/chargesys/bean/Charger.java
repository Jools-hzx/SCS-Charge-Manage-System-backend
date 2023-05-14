package com.joolshe.chargesys.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Zexi He.
 * @date 2023/5/14 16:10
 * @description:
 *
 * CREATE TABLE charger (
 *  `id` INT PRIMARY KEY AUTO_INCREMENT,   -- Charger id
 *  `status` TINYINT NOT NULL DEFAULT 0,       -- Charger 状态 0 表示空闲，1 表示占用， 2表示故障
 *  `station_Id` INT NOT NULL  		-- 所在的站点 Id
 * )CHARSET=utf8;
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Charger implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer status;

    @TableField("station_Id")
    private Integer stationId;
}
