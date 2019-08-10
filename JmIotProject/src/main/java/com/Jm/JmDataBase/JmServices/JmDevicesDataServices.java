package com.Jm.JmDataBase.JmServices;

import com.Jm.JmDataBase.DataType.JmDevicesDataType;

import java.util.List;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/29 下午2:56
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public interface JmDevicesDataServices {
    public JmDevicesDataType selectListById(String devId);

    public List<JmDevicesDataType> selectListByType(String type);

    public List<JmDevicesDataType> selectListByIp(String Ip);

    public List<JmDevicesDataType> slectListByMac(String Mac);

    public void insertDevPoint(JmDevicesDataType vPoint);

    public void updateDevPonit(JmDevicesDataType vPoint);

    public List<JmDevicesDataType> selectAllDevPoint();

    public JmDevicesDataType selectDevPointByOnlyId(String OnlyId);
}
