package com.Jm.JmMqtt.JmMqttData;

import com.alibaba.fastjson.annotation.JSONField;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public class JmReportEventMsg {
    @JSONField(name = "devid")
    private String devId;
    public void setDevId(String vId){
        this.devId = vId;
    }
    public String getDevId(){
        return this.devId;
    }

    @JSONField(name = "type")
    private int devType;
    public void setDevType(int vType){
        this.devType = vType;
    }
    public int getDevType(){
        return this.devType;
    }

    @JSONField(name = "value")
    private int devValue;
    public void setDevValue(int vValue){
        this.devValue = vValue;
    }
    public int getDevValue(){
        return this.devValue;
    }

    @JSONField(name = "alarm_value")
    private int alarmValue;
    public void setAlarmValue(int vVlaue){
        this.alarmValue = vVlaue;
    }
    public int getAlarmValue() {
        return this.alarmValue;
    }

    public boolean CheckDataValid(){
        if((devId != null) &&
          (!devId.equals(""))
        ){
            return true;
        }else {
            return false;
        }
    }
}
