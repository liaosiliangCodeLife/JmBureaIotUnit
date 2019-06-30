package com.Jm.JmDataBase.DataType;

import com.Jm.JmCommon.excel.Excel;
import com.Jm.JmMqtt.JmMqttData.JmReportEventMsg;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


public class JmDeviceEventRecordType extends JmDevicesDataType {
    public void fillWithDevType(JmDevicesDataType vFill){
        setOnlyOne(vFill.getOnlyOne());
        setDevId(vFill.getDevId());
        setDevIp(vFill.getDevIp());
        setDevType(vFill.getDevType());
        setDevIp(vFill.getDevIp());
        setDevMac(vFill.getDevMac());
        setUnity(vFill.getUnidity());
        setAlarmVakue(vFill.getAlarmValue());
        setOnLine(vFill.getOnline());
        setValue(vFill.getValue());
        setRemarkLabel(vFill.getRemark());
        setRegisterTime(vFill.getRegisterTime());
    }

    public void fillWithReportMsg(JmReportEventMsg vMsg, String vTopic){
        setTopic(vTopic);
        setReslut(Double.toString(vMsg.getDevValue()/100) + this.getUnidity());
    }

    @Excel(name = "Squeences Id")
    private long mRecordId;
    public void setRecId(long vId){
        this.mRecordId = vId;
    }
    public long getRecId(){
        return this.mRecordId;
    }

    @Excel(name = "Report result")
    private String mResult;
    public void setReslut(String vReslut){
        this.mResult = vReslut;
    }
    public String getResult(){
        return this.mResult;
    }

    @Excel(name = "Operator")
    private String mUser;
    public void setmUser(String vUser){
        this.mUser = vUser;
    }
    public String getmUser(){
        return this.mUser;
    }

    @Excel(name = "Action Of Devices")
    private String mAction;
    public void setAction(String vAction){
        this.mAction = vAction;
    }
    public String getAction(){
        return this.mAction;
    }

    @Excel(name = "Report By Witch Topic")
    private String mTopic;
    public void setTopic(String vTopic){
        this.mTopic = vTopic;
    }
    public String getTopic(){
        return this.mTopic;
    }

    @Override
    public String toString(){
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("mqtt_RecOnlyId",getOnlyOne())
                .append("mqtt_RecId",getRecId())
                .append("mqtt_RecDid",getDevId())
                .append("mqtt_RecType",getDevType())
                .append("mqtt_RecRegTime",getRegisterTime())
                .append("mqtt_RecUpTime",getUpdatetime())
                .append("mqtt_RecIp",getDevIp())
                .append("mqtt_RecMac",getDevMac())
                .append("mqtt_RecIsOnline", getOnline())
                .append("mqtt_RecMark", getRemark())
                .append("mqtt_RecValue",getValue())
                .append("mqtt_RecAlarm",getAlarmValue())
                .append("mqtt_RecUnity",getUnidity())
                .append("mqtt_RecResult",getResult())
                .append("mqtt_RecUser",getmUser())
                .append("mqtt_RecAction",getAction())
                .append("mqtt_RecTopic",getTopic())
                .toString();
    }
}
