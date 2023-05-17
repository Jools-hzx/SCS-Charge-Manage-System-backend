package com.joolshe.chargesys.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Zexi He.
 * @date 2023/5/16 23:32
 * @description:
 * CREATE TABLE `order` (
 *  `order_id` VARCHAR(64) PRIMARY KEY,	  -- 订单编号
 *  `create_time` DATETIME NOT NULL, -- 订单生成时间
 *  `price` DECIMAL(11, 2) NOT NULL, -- 订单的金额
 *  `status` TINYINT NOT NULL,	  -- 订单状态,0表示未支付,1表示已支付
 *  `member_id` INT NOT NULL,	  -- 该订单对应的用户Id
 *  `charger_id` INT NOT NULL,	  -- 该订单对应的 Charger Id
 *  `station_id` INT NOT NULL	  -- 该订单所发生的 站点 Id
 * )CHARSET utf8 ENGINE INNODB;
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "`order`")
public class Order {

    @TableId(type = IdType.AUTO)
    @TableField("order_id")
    private String orderId;

    @TableField("create_time")
    private Date createTime;

    @NotNull(message = "价格不能为空")
    @Range(min = 0, message = "价格不能小于0")
    private BigDecimal price;

    @NotNull(message = "状态不能为空")
    @Range(min = 0, max = 1, message = "订单状态不合法")
    private Integer status;

    @NotNull(message = "用户Id不能为空")
    @Range(min = 0, message = "用户id不合法")
    @TableField("user_id")
    private Integer userId;

    @NotNull(message = "充电桩Id不能为空")
    @Range(min = 0, message = "充电桩id不合法")
    @TableField("charger_id")
    private Integer chargerId;

    @NotNull(message = "充电站Id不能为空")
    @Range(min = 0, message = "充电站id不合法")
    @TableField("station_id")
    private Integer stationId;
}
