package com.Jm.JmDataBase.mapper;

import com.Jm.JmDataBase.DataType.JmDeviceEventRecordType;
import java.util.List;

public interface JmDeviceEventRecordMapper {
    public List<JmDeviceEventRecordType> selectAllMqttDevicesRecord();

    public List<JmDeviceEventRecordType> selectMqttDeviceByType(String vType);

    public List<JmDeviceEventRecordType> selectMqttDeviceByMac(String vMac);

    public List<JmDeviceEventRecordType> selectMqttDeviceByDevId(String vId);

    public void insertRecord(JmDeviceEventRecordType vRecord);
}
