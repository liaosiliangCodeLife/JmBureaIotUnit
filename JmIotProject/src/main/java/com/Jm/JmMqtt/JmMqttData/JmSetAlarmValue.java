package com.Jm.JmMqtt.JmMqttData;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/7/5 下午4:06
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public class JmSetAlarmValue {

    @JSONField(name = "devid")
    private String devId;
    public String getDevId(){
        return this.devId;
    }
    public void setDevId(String vId){
        this.devId = vId;
    }

    @JSONField(name = "type")
    private int devType;
    public int getDevType() {
        return devType;
    }
    public void setDevType(int vType){
        this.devType = vType;
    }

    @JSONField(name = "value")
    private int devAlarmValue;
    public int getDevAlarmValue() {
        return devAlarmValue;
    }
    public void setDevAlarmValue(int vValue){
        this.devAlarmValue = vValue;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
