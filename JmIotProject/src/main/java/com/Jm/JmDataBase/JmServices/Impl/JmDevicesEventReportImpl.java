package com.Jm.JmDataBase.JmServices.Impl;

import com.Jm.JmDataBase.DataType.JmDeviceEventRecordType;
import com.Jm.JmDataBase.JmServices.JmDevicesEventServices;
import com.Jm.JmDataBase.mapper.JmDeviceEventRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/29 下午3:02
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Service("useForJmDevicesReportEventServices")
public class JmDevicesEventReportImpl implements JmDevicesEventServices {
    @Autowired
    private JmDeviceEventRecordMapper mRecMapper;

    @Override
    public List<JmDeviceEventRecordType> selectAllMqttDevicesRecord() {
        return mRecMapper.selectAllMqttDevicesRecord();
    }

    @Override
    public List<JmDeviceEventRecordType> selectMqttDeviceByType(String vType) {
        return mRecMapper.selectMqttDeviceByType(vType);
    }

    @Override
    public List<JmDeviceEventRecordType> selectMqttDeviceByMac(String vMac) {
        return mRecMapper.selectMqttDeviceByMac(vMac);
    }

    @Override
    public List<JmDeviceEventRecordType> selectMqttDeviceByDevId(String vId) {
        return mRecMapper.selectMqttDeviceByDevId(vId);
    }

    @Override
    public void insertRecord(JmDeviceEventRecordType vRecord) {
        mRecMapper.insertRecord(vRecord);
    }
}

