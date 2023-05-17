# SCS-Charging-Manage-System

# Version 1.0 版本小结


## 主要使用技术栈:

### 前端技术栈
Vue 3 + Axios + ElementPlus

### 后端技术栈
SpringBoot + MyBatis Plus

### 数据库
MySQL  [ 数据源: DruidDataSources ]

### 项目依赖管理
Maven

### 1.0初版完成的功能有
**后端服务:**
1.管理员登录

2.充电站点管理【注册、添加、更新、删除、查询】

3.充电桩管理 【更新状态、删除、查询】

4.用户显示管理 【分页显示】

5.订单显示管理 【分页显示】

**前端：**
1.router导航实现跳转

2.解决 Axios 请求跨域问题

3.多个管理页面和 Elements-plus 引用






## 部署

### 前端程序: 
需要先下载 node.js LTS 并安装 : node.js 的 npm，用于管理前端项目包依赖

默认启动端口修改为为: 10000 [vue.config.js]

src/views 目录下： 主要页面

src/components 目录下: 页面布局使用到的导航栏、头部组件

### 后端程序:
默认启动端口修改为: 9090

其他配置详见 resources/application.yml 文件

### 数据库

执行 SQL-01.sql






## FUTURE -- 未来待完善

```
一、实现站点详情页面:
 	完成充电桩的添加
 
二、用户管理页面:
 1.用户注销/激活功能
 2.根据名称关键字查找用户
 
三、实现普通用户权限功能:
 1.登录
 2.查看站点详情
 3.充值
 
四、拦截未登录的请求

```