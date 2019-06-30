package com.Jm.JmMqtt.JmMqttData;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public class JmRegMsg  {
    @JSONField(name = "mac")
    private String macAddr;
    public void setMacAddr(String vAddr){
        this.macAddr = vAddr;
    }
    public String getMacAddr(){
        return this.macAddr;
    }

    @JSONField(name = "SN")
    private String snNum;
    public void setSnNum(String vNum){
        this.snNum = vNum;
    }
    public String getSnNum(){
        return this.snNum;
    }

    @JSONField(name = "ip")
    private String ipAddr;
    public void setIpAddr(String vIp){
        this.ipAddr = vIp;
    }
    public String getIpAddr(){
        return this.ipAddr;
    }

    @JSONField(name = "type")
    private int[] typeArray;
    public void setTypeArray(int[] vArry){
        this.typeArray = vArry;
    }
    public int[] getTypeArry(){
        return this.typeArray;
    }

    @Override
    public String toString() {
         return JSONObject.toJSONString(this);
    }
}
