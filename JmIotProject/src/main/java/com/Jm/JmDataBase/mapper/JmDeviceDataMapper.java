package com.Jm.JmDataBase.mapper;

import com.Jm.JmDataBase.DataType.JmDevicesDataType;
import java.util.List;

public interface JmDeviceDataMapper {
    public JmDevicesDataType selectListById(String devId);

    public List<JmDevicesDataType> selectListByType(String type);

    public List<JmDevicesDataType> selectListByIp(String Ip);

    public List<JmDevicesDataType> slectListByMac(String Mac);

    public void insertDevPoint(JmDevicesDataType vPoint);

    public void updateDevPonit(JmDevicesDataType vPoint);

    public List<JmDevicesDataType> selectAllDevPoint();

    public JmDevicesDataType selectDevPointByOnlyId(String OnlyId);
}
