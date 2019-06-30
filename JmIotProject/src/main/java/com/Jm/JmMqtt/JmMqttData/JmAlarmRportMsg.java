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
public class JmAlarmRportMsg {
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
    private int getDevType(){
        return this.devType;
    }

    @JSONField(name = "msg")
    private String alarnMsg;
    public void setAlarnMsg(String vMsg){
        this.alarnMsg = vMsg;
    }
    public String getAlarnMsg(){
        return this.alarnMsg;
    }
}
