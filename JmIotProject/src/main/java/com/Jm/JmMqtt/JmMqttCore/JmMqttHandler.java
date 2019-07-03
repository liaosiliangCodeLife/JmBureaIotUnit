package com.Jm.JmMqtt.JmMqttCore;

import com.Jm.JmCommon.annotation.SubTopic;;
import com.Jm.JmCommon.base.JmMqttUntils;
import com.Jm.JmCommon.common.AjaxResult;
import com.Jm.JmCommon.excel.ExcelUtil;
import com.Jm.JmDataBase.DataType.JmDeviceEventRecordType;
import com.Jm.JmDataBase.DataType.JmDevicesDataType;
import com.Jm.JmMqtt.JmMqttData.JmRegBackMsg;
import com.Jm.JmMqtt.JmMqttData.JmRegMsg;
import com.Jm.JmMqtt.JmMqttData.JmReportEventMsg;
import com.Jm.JmMqtt.JmMqttInterface.JmMqttHandlerServices;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Service
public class JmMqttHandler  implements JmMqttHandlerServices {
    private static final Logger mqttLogger =  LoggerFactory.getLogger(JmMqttConfigure.class);

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:27 2019/6/30
     * @Param [vTopic, vPayload, vAction]
     * @return void
     **/
    private void handleCommonMsg(String vTopic, String vPayload, String vAction){
        JmReportEventMsg iRepMsg = JSON.parseObject(vPayload, JmReportEventMsg.class);
        String iOnlyId = iRepMsg.getDevId() + "@" + iRepMsg.getDevType();
        JmDevicesDataType iSearch = JmMqttDataUnity.getInstance().getDevHashTable().get(iOnlyId);
        if( null != iSearch ){
            iSearch.setAlarmVakue(Double.toString(iRepMsg.getAlarmValue()/100));
            iSearch.setValue(Double.toString(iRepMsg.getDevValue()/100));

            JmDeviceEventRecordType iRec = new JmDeviceEventRecordType();
            iRec.fillWithDevType(iSearch);
            iRec.fillWithReportMsg(iRepMsg, vTopic);
            iRec.setAction(vAction);
            iRec.setmUser("admin");
            JmMqttDataUnity.getInstance().getHandleDataTable().updateDevPonit(iSearch);
            JmMqttDataUnity.getInstance().getRecordTable().insertRecord(iRec);
            JmMqttDataUnity.getInstance().getDevHashTable().remove(iOnlyId);
            JmMqttDataUnity.getInstance().getDevHashTable().put(iOnlyId, iSearch);
        }else{
            mqttLogger.error("====================Error Start============================");
            mqttLogger.error("The Devices Report Msg:  "+ vPayload + "  Not Exits Pls Check!!!");
            mqttLogger.error("====================Error End===============================");
        }
    }
    
    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 下午7:50 2019/6/29
     * @Param [vTopic, vPayload]
     * @return void
     **/
    @SubTopic(name = "/Jm/Iot/RegisterDevice")
    private void handleRegisterMsg(String vTopic, String vPayload){
        JmRegMsg iRegMsg = JSON.parseObject(vPayload, JmRegMsg.class);
        String iGenId = JmMqttUntils.generateDevId(iRegMsg.getSnNum() + iRegMsg.getMacAddr());
        JmRegBackMsg iBack = new JmRegBackMsg(iRegMsg);

        iBack.setDevId(iGenId);
        int[] typeMap = iRegMsg.getTypeArry();

        for(int i=0; i<typeMap.length; i++){
            JmDevicesDataType iTmpType = new JmDevicesDataType();
            iTmpType.fillInfoWithRegMsg(iRegMsg,iGenId,typeMap[i]);

            if( !JmMqttDataUnity.getInstance().getDevHashTable().containsKey(iTmpType.getOnlyOne())) {
                iBack.setResultCode(JmMqttUntils.OK_CODE);
                JmMqttDataUnity.getInstance().getHandleDataTable().insertDevPoint(iTmpType);
                JmMqttDataUnity.getInstance().getDevHashTable().put(iTmpType.getOnlyOne(),iTmpType);
            }else{
                iBack.setResultCode(JmMqttUntils.ALREADY_REGISTER_CODE);
                mqttLogger.error("====================Error Start============================");
                mqttLogger.error("The Devices Onlyone Num: ", iTmpType.getOnlyOne());
                mqttLogger.error("The Devices Id: ", iTmpType.getDevId());
                mqttLogger.error("The Devices Mac : ", iTmpType.getDevMac());
                mqttLogger.error("already Exit!!!!");
                mqttLogger.error("====================Error End===============================");
            }
        }
        JmMqttDataUnity.getInstance().SendOutDataByTopic(
                JmMqttPublishConfigure.JMREG_BACK_MSG_PREFIX + iRegMsg.getMacAddr(),
                JSON.toJSONString(iBack)
        );
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 下午8:33 2019/6/29
     * @Param [vTopic, vPayload]
     * @return void
     **/
    @SubTopic(name = "/Jm/Iot/ReportEvent")
    private void handleReportEventMsg(String vTopic, String vPayload){
        System.out.println("Msg: " + vPayload);
        handleCommonMsg(vTopic, vPayload, "ReportEvent");
        ExcelUtil<JmDeviceEventRecordType> util = new ExcelUtil<JmDeviceEventRecordType>(JmDeviceEventRecordType.class);
        util.exportExcel(JmMqttDataUnity.getInstance().getRecordTable().selectAllMqttDevicesRecord(), "TestExcel");
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 下午8:33 2019/6/29
     * @Param [vTopic, vPayload]
     * @return void
     **/
    @SubTopic(name = "/Jm/Iot/AlarmReport")
    private void handleAlarmRepotEvent(String vTopic, String vPayload){
        handleCommonMsg(vTopic, vPayload, "AlarmEvent");
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 下午8:33 2019/6/29
     * @Param [vName, vTopic]
     * @return boolean
     **/
    private boolean isTopic(String vName, String vTopic){
       // System.out.println("Name: " + vName + " Topic: " + vTopic);
        if( vName.equals(vTopic)){
            return true;
        }else if(vName.contains("#")){
            return vTopic.contains(vName.replace("#", ""));
        }else{
            return false;
        }
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 下午8:34 2019/6/29
     * @Param [vTopic, vPayload]
     * @return void
     **/
    public void IotMqttMainHanlder(String vTopic, String vPayload)  {
        System.out.println("Handle with Topic: " + vTopic);
        System.out.println("Handle with Msg: " + vPayload);

        Method[]iMethod = this.getClass().getDeclaredMethods();
        for(int i=0; i <iMethod.length; i++){
            SubTopic iTopic = iMethod[i].getAnnotation(SubTopic.class);
            if(iTopic != null && isTopic(iTopic.name(), vTopic)){
                try {
                    iMethod[i].invoke(this, vTopic, vPayload);
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    mqttLogger.error("Can not get the Topic method :" + vTopic + " with msg: " + vPayload);
                }
            }else if( i ==  iMethod.length -1){
                mqttLogger.error("Can not Solve the Topic method :" + vTopic + " with msg: " + vPayload);
            }
        }
    }
}
