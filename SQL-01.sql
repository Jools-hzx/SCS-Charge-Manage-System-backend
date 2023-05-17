-- 创建数据库
DROP DATABASE IF EXISTS springboot_charge_sys;
CREATE DATABASE springboot_charge_sys;
USE springboot_charge_sys;


-- 创建管理员 admin 表
CREATE TABLE `admin`(
 `id` INT PRIMARY KEY AUTO_INCREMENT,
 `name` VARCHAR(32) ,
 `password` VARCHAR(64) 
)CHARSET=utf8;

SELECT * FROM `admin`;

-- 添加有效管理员用户数据
INSERT INTO `admin` VALUES(NULL, "Jools_He", "hzx"),(NULL, "Wakoo", "hzx");




-- 创建充电站点表
CREATE TABLE station (
 `id` INT PRIMARY KEY AUTO_INCREMENT,		#编号
 `name` VARCHAR( 32 ) NOT NULL UNIQUE,		#站点名
 `operator` VARCHAR( 32 ) NOT NULL,		#运营商
 `price` DECIMAL(11,2) NOT NULL DEFAULT 1.0,	#实时电价
 `available_charger` INT NOT NULL,		#可用充电枪数量
 `total_charger` INT NOT NULL,			#该站点充电枪总数量
 `img_path` VARCHAR(256) NOT NULL,		#存放的站点图片路径
 `location` VARCHAR(32) NOT NULL DEFAULT ''	#位置信息
)CHARSET utf8;

-- 插入测试数据
 INSERT INTO station
(`id`, `name`, `operator`, `price`, `available_charger`, `total_charger`, `img_path`,`location`)
VALUES(NULL, '汇充电003', '汇充电', 1.2, 1, 1, 'resources/images/Charge_station_01.png', '深圳');

 INSERT INTO station
(`id`, `name`, `operator`, `price`, `available_charger`, `total_charger`, `img_path`,`location`)
VALUES(NULL, '特来电001', '特来电', 1.2, 1, 1, 'resources/images/Charge_station_01.png', '广州');

 INSERT INTO station
(`id`, `name`, `operator`, `price`, `available_charger`, `total_charger`, `img_path`,`location`)
VALUES(NULL, 'BYD充电湾', 'BYD', 1.2, 1, 1, 'resources/images/Charge_station_01.png', '深圳');

-- 查询充电站点表
SELECT 
id, `name`, `operator`, `price`, 
available_charger AS availableCharger, 
total_charger AS totalCharger, 
img_path AS imgPath,
location
FROM station; 



-- 添加充电桩表
CREATE TABLE charger (
 `id` INT PRIMARY KEY AUTO_INCREMENT,   -- Charger id
 `status` TINYINT NOT NULL DEFAULT 0,       -- Charger 状态 0 表示空闲，1 表示占用， 2表示故障
 `station_Id` INT NOT NULL  		-- 所在的站点 Id 
)CHARSET=utf8;

DROP TABLE charger

-- 插入一条测试数据，由于充电桩会和充电站点绑定，
-- 待项目启动成功后通过添加站点可以同时插入数据到 charger
INSERT INTO charger(`id`, `status`, `station_Id`) VALUES(NULL, 0, 3);

SELECT * FROM charger;

SELECT c.*, s.name AS station_name
FROM charger AS c, station AS s
WHERE c.id = s.id
LIMIT 0,3


-- 创建用户表
CREATE TABLE `user` (
 `id` INT PRIMARY KEY AUTO_INCREMENT,	-- 用户 id
 `username` VARCHAR( 32 ) NOT NULL UNIQUE, -- 用户名
 `password` VARCHAR( 32 ) NOT NULL,	-- 用户密码
 `email` VARCHAR( 64 ),			-- 电子邮箱
 `phone` VARCHAR( 20 ),			-- 手机号码
 `balance` DECIMAL(11, 2) NOT NULL DEFAULT 0.0	-- 账户余额
)CHARSET=utf8;

SELECT * FROM `user`;

-- 添加测试用户数据到 user 表中
INSERT INTO `user`(`id`, `username`, `password`, `email`, `phone`, `balance`) 
VALUES(NULL, 'Tommy111', MD5('123456'), 'Tommy11@qq.com', '13602559222', 19.99);

INSERT INTO `user`(`id`, `username`, `password`, `email`, `phone`, `balance`) 
VALUES(NULL, 'TommyAAA', MD5('123456'), 'TommyAAA@qq.com', '13602559222', 19.99);

INSERT INTO `user`(`id`, `username`, `password`, `email`, `phone`, `balance`) 
VALUES(NULL, 'TommyBBB', MD5('123456'), 'TommyBBB@qq.com', '13602559222', 19.99);


-- 创建订单表
CREATE TABLE `orders` (
 `order_id` VARCHAR(64) PRIMARY KEY,	  -- 订单编号
 `create_time` DATETIME NOT NULL, -- 订单生成时间
 `price` DECIMAL(11, 2) NOT NULL, -- 订单的金额
 `status` TINYINT NOT NULL,	  -- 订单状态,0表示未支付,1表示已支付
 `user_id` INT NOT NULL,	  -- 该订单对应的用户Id
 `charger_id` INT NOT NULL,	  -- 该订单对应的 Charger Id
 `station_id` INT NOT NULL	  -- 该订单所发生的 站点 Id
)CHARSET utf8 ENGINE INNODB;

DROP TABLE `orders`;

-- 插入测试数据
INSERT INTO `orders` 
(`order_id`,`create_time`,`price`,`status`,`user_id`,`charger_id`,`station_id`) 
VALUES(1, NOW(), 10, 0, 1, 1, 1);

SELECT * FROM `orders`;

