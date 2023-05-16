package com.joolshe.chargesys.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Zexi He.
 * @date 2023/5/14 15:16
 * @description:
 *
 * -- 创建充电站点表
 * CREATE TABLE station (
 *  `id` INT PRIMARY KEY AUTO_INCREMENT,		#编号
 *  `name` VARCHAR( 32 ) NOT NULL UNIQUE,		#站点名
 *  `operator` VARCHAR( 32 ) NOT NULL,		#运营商
 *  `price` DECIMAL(11,2) NOT NULL DEFAULT 1.0,	#实时电价
 *  `available_charger` INT NOT NULL,		#可用充电枪数量
 *  `total_charger` INT NOT NULL,			#该站点充电枪总数量
 *  `img_path` VARCHAR(256) NOT NULL,		#存放的站点图片路径
 *  `location` VARCHAR(32) NOT NULL DEFAULT ''	#位置信息
 * )CHARSET utf8;
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @NotEmpty(message = "名称不能为空")
    private String name;

    @NotEmpty(message = "运营商不能为空")
    private String operator;

    @NumberFormat(pattern="###.##")
    @NotNull(message = "价格不能为空")
    @Range(min = 0, message = "价格设置不正确")
    protected BigDecimal price;

    @TableField("available_charger")
//    @NotNull(message = "可用桩数目不能为空")             由于添加站点时，总桩数目即为可用桩数目，暂时注释掉校验规则
//    @Range(min = 0, message = "可用桩数目需大于等于0")
    private Integer availableCharger;

    @NotNull
    @Range(min = 1, message = "总桩数目需大于等于1")
    @TableField("total_charger")
    private Integer totalCharger;

    @TableField("img_path")
    private String imagePath = "resources/images/xxx.png";  //TODO support upload station image

    @NotEmpty(message = "地点信息不能为空")
    private String location;

}
