package com.Jm.JmDataBase.DataType;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/7/3 下午8:04
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public class HttpResonseData {

    @JSONField(name = "Device")
    public JmDevicesDataType mType;

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午8:56 2019/7/3
     * @Param [vData]
     * @return 
     **/
    public HttpResonseData(JmDevicesDataType vData){
        this.mType = vData;
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午8:56 2019/7/3
     * @Param []
     * @return java.lang.String
     **/
    @Override
    public String toString(){
        return  JSONObject.toJSONString(mType.getClass());
    }
}
