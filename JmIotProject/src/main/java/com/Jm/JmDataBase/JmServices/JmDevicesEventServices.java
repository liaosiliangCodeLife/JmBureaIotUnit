package com.Jm.JmDataBase.JmServices;

import com.Jm.JmDataBase.DataType.JmDeviceEventRecordType;

import java.util.List;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/29 下午2:57
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public interface JmDevicesEventServices {
    public List<JmDeviceEventRecordType> selectAllMqttDevicesRecord();

    public List<JmDeviceEventRecordType> selectMqttDeviceByType(String vType);

    public List<JmDeviceEventRecordType> selectMqttDeviceByMac(String vMac);

    public List<JmDeviceEventRecordType> selectMqttDeviceByDevId(String vId);

    public void insertRecord(JmDeviceEventRecordType vRecord);
}
