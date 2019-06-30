package com.Jm.JmDataBase.JmServices.Impl;

import com.Jm.JmDataBase.DataType.JmDevicesDataType;
import com.Jm.JmDataBase.JmServices.JmDevicesDataServices;
import com.Jm.JmDataBase.mapper.JmDeviceDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/29 下午2:59
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Service("useForDeviceDataServices")
public class JmDevicesDataImpl implements JmDevicesDataServices {
    /**
     * connecting to data base
     */
    @Autowired
    private JmDeviceDataMapper mPointMapper;

    @Override
    public JmDevicesDataType selectListById(String devId) {
        return mPointMapper.selectListById(devId);
    }

    @Override
    public List<JmDevicesDataType> selectListByType(String type) {
        return mPointMapper.selectListByType(type);
    }

    @Override
    public List<JmDevicesDataType> selectListByIp(String Ip) {
        return mPointMapper.selectListByIp(Ip);
    }

    @Override
    public List<JmDevicesDataType> slectListByMac(String Mac) {
        return mPointMapper.slectListByMac(Mac);
    }

    @Override
    public void insertDevPoint(JmDevicesDataType vPoint) {
        mPointMapper.insertDevPoint(vPoint);
    }

    @Override
    public void updateDevPonit(JmDevicesDataType vPoint) {
        mPointMapper.updateDevPonit(vPoint);
    }

    @Override
    public List<JmDevicesDataType> selectAllDevPoint() {
        return mPointMapper.selectAllDevPoint();
    }
}

