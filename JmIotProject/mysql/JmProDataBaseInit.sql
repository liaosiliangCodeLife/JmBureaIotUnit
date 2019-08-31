-- ----------------------------
-- 1、Table Of The Devices Ponit
-- ----------------------------
drop table if exists Jm_IotDevicesData_Table;
create table Jm_IotDevicesData_Table(
   mqtt_devsearchId   int(16)       not null auto_increment comment 'Search Id Of the devices',
   mqtt_devonlyId     varchar(64)   not null                comment 'The only one of the vallue',
   mqtt_devid         varchar(64)   not null                comment 'deviceid Of the Point',
   mqtt_devType       varchar(64)   not null                comment 'device type Of the point',
   mqtt_devUpTime     datetime(6)   not null                comment 'devices update tume',
   mqtt_devMac        varchar(64)   not null                comment 'device point mac address',
   mqtt_devIp         varchar(64)   not null                comment 'devices ip',
   mqtt_devRegTime    datetime(6)   not null                comment 'device point register time',
   mqtt_devValue      varchar(16)   default ''              comment 'debvice value',
   mqtt_devIsOnline   varchar(16)   default ''              comment 'device is online ?',
   mqtt_devAlarmValue varchar(16)   default ''              comment 'device alarm value',
   mqtt_devUnity      varchar(16)   default ''              comment 'device unity' ,
   mqtt_devMark       varchar(1024) default  ''             comment 'device comment',
   primary key (mqtt_devsearchId)
)engine=innodb auto_increment=200 default charset=utf8 comment = 'device point data';

insert into  Jm_IotDevicesData_Table values (0, '12345678890ABCDWENJNJDNJNSJBNSJ1','12345678890ABCDWENJNJDNJNSJBNSJ','supertype',sysdate(),'192.168.1.1',
                                         '00:00:00:00:00:00', sysdate(), '00','OffLine', '11',
                                         'U','Super devices');


-- ----------------------------
-- 2、Table Of The Devices Record
-- ----------------------------
drop table if exists Jm_DevicesRecordDeviceData_table;
create table Jm_DevicesRecordDeviceData_table(
  mqtt_RecId          int(16)       not null  auto_increment comment 'record id of the index',
  mqtt_RecOnlyId      varchar(64)   default ''               comment 'Only one id for each channel',
  mqtt_RecDid         varchar(64)   default ''               comment 'record the deviceid of the devices',
  mqtt_RecType        varchar(64)   default ''               comment 'record the device tyoe of the devices',
  mqtt_RecUpTime      datetime(6)   not null                 comment 'devices update time',
  mqtt_RecIp          varchar(64)   default ''               comment 'Ip of Report',
  mqtt_RecMac         varchar(64)   not null                 comment 'device point mac address',
  mqtt_RecRegTime     datetime(6)  not null                 comment 'device point register time',
  mqtt_RecValue       varchar(16)   default ''               comment 'debvice value',
  mqtt_RecIsOnline    varchar(16)   default ''               comment 'device is online ?',
  mqtt_RecAlarmValue  varchar(16)   default ''               comment 'device alarm value',
  mqtt_RecUnity       varchar(16)   default ''               comment 'device unity' ,
  mqtt_RecMark        varchar(1024) default  ''              comment 'device comment',
  mqtt_RecResult      varchar(128)  default ''               comment 'Result of the device',
  mqtt_RecUser        varchar(128)  default ''               comment 'record the user of the device',
  mqtt_RecAction      varchar(32)   default ''               comment 'record action of the device',
  mqtt_RecTopic       varchar(128)  default ''                comment 'record topic of the device',
  primary key (mqtt_RecId)
)engine=innodb auto_increment=200 default charset=utf8 comment = 'device point data';

insert into  Jm_DevicesRecordDeviceData_table values (0, '12345678890ABCDWENJNJDNJNSJBNSJ@1','12345678890ABCDWENJNJDNJNSJBNSJ','supertype',sysdate(),
                                       '182.190.77.88','00:00:00:00:00:00', sysdate(), '00','OffLine', '11','U',
                                       'Super devices','99c','device', 'report','/test');
