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
public class JmRegBackMsg {

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午8:24 2019/6/29
     * @Param [vMsg]
     * @return 
     **/
    public JmRegBackMsg(JmRegMsg vMsg){
        setTypeArray(vMsg.getTypeArry());
        setSnNum(vMsg.getSnNum());
        setMacAddr(vMsg.getMacAddr());
    }

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

    @JSONField(name = "devid")
    private String devId;
    public void setDevId(String vId){
        this.devId = vId;
    }
    public String getDevId(){
        return this.devId;
    }

    @JSONField(name = "type")
    private int[] typeArray;
    public void setTypeArray(int[] vArry){
        this.typeArray = vArry;
    }
    public int[] getTypeArry(){
        return this.typeArray;
    }

    @JSONField(name = "result")
    private int resultCode;
    public void setResultCode(int vCode){
        this.resultCode = vCode;
    }
    public int getResultCode(){
        return this.resultCode;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
