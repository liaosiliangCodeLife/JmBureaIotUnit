# JmBureaIotUnit
# 设备交互协议
## 设备端
### 目的：第一次设备上线注册，以获取devid。
Push Topic:/Jm/Iot/RegisterDevice
格式：
{
    "mac":"11:22:33:44:55:66:77",
    "SN":"0123456789",
    "ip":"192.168.1.1",
    "type":123
}
type: 0:gw 1:hum 2:tem 3:fan
策略：没有注册的情况下上电一次就注册一次。注册成功后，devid存储在设备中。之后不在注册，直接登录，注册为设备认证过程。
说明：一个设备有多个type值用数组表示，我们这边是[1,2,3]


### 目的：设备注册结果
Sub  Topic:/Jm/Iot/RegisterResult/[mac]
格式：
{
    "mac":"11:22:33:44:55:66:77",
    "SN":"0123456789",
    "devid":"0123456789",
    "result":int,
    "type":123
}
策略：收到这个回复后不再订阅/Jm/Iot/RegisterDevice Topic，取消订阅
result: 0表示成功 其他101已经被注册

### 设备上报信息，信息由字段名区分
Push Topic:/Jm/Iot/ReportEvent
格式{"devid":"123456","value":34.8,"type":123,"alarm_value":999}
策略：10秒钟上报一次

### 目的：设备监控告警
Push Topic:/Jm/Iot/AlarmRport
Push Topic:/Jm/Iot/ReportEvent
格式{"devid":"123456","value":34.8,"type":123,"alarm_value":999}

### 目的:设置设备监测阀值或控制设备
Sub Topic:/Jm/Iot/Setvalue/[devid]
策略：监测到devid和自己的devid一致就设置

### 目的： 控制接口
Sub Topic:/Jm/Iot/Ctrl/devid
格式：
{
    "method":"upgrade"
}
策略：设备控制接口，目前基础功能为重启，更新等等，后续可添加

## WEB端:
### 待更新...








