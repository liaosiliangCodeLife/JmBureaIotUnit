package com.Jm.JmDataBase.DataType;

import com.Jm.JmCommon.base.JmMqttUntils;
import com.Jm.JmCommon.common.DateUtils;
import com.Jm.JmCommon.excel.Excel;
import com.Jm.JmMqtt.JmMqttData.JmRegMsg;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JmDevicesDataType implements Serializable {
    private static final long serialVersionUID = 52013148023L;
    
    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午8:08 2019/6/29
     * @Param [vMsg, vId, vType]
     * @return void
     **/
    public void fillInfoWithRegMsg(JmRegMsg vMsg, String vId, int vType){
        setDevId(vId);
        setDevMac(vMsg.getMacAddr());
        setDevIp(vMsg.getIpAddr());
        setDevType(JmMqttUntils.DEV_TYPE_MAP[vType]);
        setOnlyOne(vId + "@" + vType);
        setUnity(JmMqttUntils.DEV_UNITY_MAP[vType]);
    }

    @Excel(name = "SerchId")
    private long mSearchId;
    public void setSearcid(long vSearchId){
        this.mSearchId = vSearchId;
    }
    @JSONField(serialize = false)
    public long getSearchid(){
        return this.mSearchId;
    }

    @Excel(name = "OnlyOneId")
    private String mOnlyOne;
    public void setOnlyOne(String vOlny){
        this.mOnlyOne = vOlny;
    }
    @JSONField(name = "DevicesOnlyOneId")
    public String getOnlyOne(){
        return this.mOnlyOne;
    }

    @Excel(name = "Devices Id")
    private String mDevId;
    public void setDevId(String vId){
        this.mDevId = vId;
    }
    @JSONField(name = "DevicesId")
    public String getDevId(){
        return this.mDevId;
    }

    @Excel(name = "Devices type")
    private String mDevType;
    public void setDevType(String vTyp){
        this.mDevType = vTyp;
    }
    @JSONField(name = "DeviceType")
    public String getDevType(){
        return this.mDevType;
    }

    @Excel(name = "Device Latest Update Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mDevUpdateTime;
    public void setUpdateTime(Date vDate){
        this.mDevUpdateTime = vDate;
    }
    @JSONField(serialize = false)
    public Date getUpdatetime(){
        return this.mDevUpdateTime;
    }

    @Excel(name = "Devices Mac Address")
    private String mDevMac;
    public void setDevMac(String vMac){
        this.mDevMac = vMac;
    }
    @JSONField(name = "DeviceMac")
    public String getDevMac(){
        return this.mDevMac;
    }

    @Excel(name = "Ip Address  When Device Rergister By")
    private String mDevIp;
    public void setDevIp(String vIp){
        this.mDevIp = vIp;
    }
    @JSONField(name = "DeviceIp")
    public String getDevIp(){
        return this.mDevIp;
    }

    @Excel(name = "The Devices Register Time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date mRegisterTime;
    public void setRegisterTime(Date vDate){
        this.mRegisterTime = vDate;
    }
    @JSONField(serialize = false)
    public Date getRegisterTime(){
        return this.mRegisterTime;
    }

    @Excel(name = "Network status when we Import it")
    private String mIsOnline = JmMqttUntils.DATA_DEFAULT_STR;
    public void setOnLine(String vOnline){
        this.mIsOnline = vOnline;
    }
    @JSONField(name = "Status")
    public String getOnline(){
        return this.mIsOnline;
    }

    @Excel(name = "Latest Report value ")
    private String mValue = JmMqttUntils.DATA_DEFAULT_STR;
    public void setValue(String vValue){
        this.mValue = vValue;
    }
    @JSONField(name = "Value")
    public String getValue(){
        return this.mValue;
    }

    @Excel(name = "The Devices Alarm Value")
    private String mAlarmValue = JmMqttUntils.DEV_ALARM_VALUE;
    public void setAlarmVakue(String vAlarm){
        this.mAlarmValue = vAlarm;
    }
    @JSONField(name = "ALarmValue")
    public String getAlarmValue(){
        return this.mAlarmValue;
    }

    @Excel(name = "Unidity Of The Devices")
    private String mUnity;
    public void setUnity(String vUnity){
        this.mUnity = vUnity;
    }
    @JSONField(name = "Unity")
    public String getUnidity(){
        return this.mUnity;
    }

    @Excel(name = "User Defined Info of the Devices")
    private String mRemarkLabel = JmMqttUntils.DATA_DEFAULT_STR;
    public void setRemarkLabel(String vMrk){
        this.mRemarkLabel = vMrk;
    }
    @JSONField(name = "Remark")
    public String getRemark(){
        return this.mRemarkLabel;
    }

    @Override
    public String toString(){
       return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("mqtt_searchId",getSearchid())
                .append("mqtt_onlyId",getOnlyOne())
                .append("mqtt_devid",getDevId())
                .append("mqtt_devType",getDevType())
                .append("mqtt_devRegTime",getRegisterTime())
                .append("mqtt_devUpTime",getUpdatetime())
                .append("mqtt_devIp",getDevIp())
                .append("mqtt_devMac",getDevMac())
                .append("mqtt_devIsOnline", getOnline())
                .append("mqtt_devMark", getRemark())
                .append("mqtt_devValue",getValue())
                .append("mqtt_devAlarm",getAlarmValue())
                .append("mqtt_devUnity",getUnidity())
                .toString();

    }

    @JSONField(name="RegisterTime")
    public String getForJsonRegTime() {
       return DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, this.mRegisterTime);
    }

    @JSONField(name = "DeviceUpdateTime")
    public String getForJsonUpTime(){
        return DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, this.mDevUpdateTime);
    }



    public String forJsonString(){
        return JSONObject.toJSONString(this);
    }

}
