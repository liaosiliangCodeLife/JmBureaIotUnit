package com.Jm.JmMqtt.JmMqttCore;

import com.Jm.JmCommon.base.JmMqttUntils;
import com.Jm.JmDataBase.DataType.JmDeviceEventRecordType;
import com.Jm.JmDataBase.DataType.JmDevicesDataType;
import com.Jm.JmDataBase.JmServices.JmDevicesDataServices;
import com.Jm.JmDataBase.JmServices.JmDevicesEventServices;
import com.Jm.JmMqtt.JmMqttData.JmSetAlarmValue;
import com.Jm.JmMqtt.JmMqttInterface.JmMqttSendData;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Component
public class JmMqttDataUnity  {
    private static JmMqttDataUnity instance = null;
    private HashMap<String, JmDevicesDataType> devHashTable = null;

    @Autowired
    private  JmMqttSendData sendOutData;

    @Autowired
    @Qualifier("useForDeviceDataServices")
    private  JmDevicesDataServices handleDataTable;

    @Autowired
    @Qualifier("useForJmDevicesReportEventServices")
    private JmDevicesEventServices handleDataEventTable;


    /*
     * @Author Liaosiliang
     * @Description //Init function
     * @Date 下午12:45 2019/6/29
     * @Param []
     * @return void
     **/
    @PostConstruct
    private void initTheInstance(){
       devHashTable = new HashMap<String, JmDevicesDataType>();
       List<JmDevicesDataType> devListTable = handleDataTable.selectAllDevPoint();
        for(int i=0; i<devListTable.size(); i++){
            JmDevicesDataType iTmp = devListTable.get(i);
            devHashTable.put(iTmp.getOnlyOne(), iTmp);
            System.out.println("Test get the only id: " + iTmp.getOnlyOne());
            System.out.println("Test get the only time: " + iTmp.getRegisterTime());
        }
        instance = this;
    }


    /*
    * @Author Liaosiliang
    * @Description //TODO
    * @Date 上午4:52 2019/6/30
    * @Param [vTopic, vData]
    * @return void
    **/
   public void SendOutDataByTopic(String vTopic, String vData){
        sendOutData.SendDataWithTopic( vData,vTopic);
    }


    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 上午4:52 2019/6/30
     * @Param []
     * @return com.Jm.JmDataBase.JmServices.JmDevicesDataServices
     **/
    public JmDevicesDataServices getHandleDataTable(){
        return this.handleDataTable;
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 上午4:52 2019/6/30
     * @Param []
     * @return java.util.HashMap<java.lang.String,com.Jm.JmDataBase.DataType.JmDevicesDataType>
     **/
    public HashMap<String, JmDevicesDataType> getDevHashTable(){
        return this.devHashTable;
    }


    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 上午4:52 2019/6/30
     * @Param []
     * @return java.util.List<com.Jm.JmDataBase.DataType.JmDevicesDataType>
     **/
    public List<JmDevicesDataType> getDevListData(){
       return  handleDataTable.selectAllDevPoint();
    }


    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 上午11:28 2019/6/30
     * @Param []
     * @return com.Jm.JmDataBase.JmServices.JmDevicesEventServices
     **/
    public JmDevicesEventServices getRecordTable(){
        return this.handleDataEventTable;
    }


    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午4:25 2019/7/5
     * @Param [value, vOnlyId]
     * @return void
     **/
    public void setDevicesAlarmValue(float value, String vOnlyId){
        JmDevicesDataType iData = this.devHashTable.get(vOnlyId);
        JmDeviceEventRecordType iRec = new JmDeviceEventRecordType();
        String iTopic = JmMqttUntils.SET_VALUE_PREFIX + iData.getDevId();
        iData.setAlarmVakue(Float.toString(value));

        iRec.fillWithDevType(iData);
        iRec.setAction("SetAlarmValue");
        iRec.setTopic(iTopic);
        iRec.setmUser("admin");

        this.handleDataTable.updateDevPonit(iData);
        this.handleDataEventTable.insertRecord(iRec);

        JmSetAlarmValue iSet = new JmSetAlarmValue();
        iSet.setDevAlarmValue(Float.floatToIntBits(value*100));
        iSet.setDevId(iData.getDevId());
        iSet.setDevType(Integer.parseInt(iData.getOnlyOne().split("@")[1]));
        this.sendOutData.SendDataWithTopic(JSON.toJSONString(iSet), iTopic);
    }


    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 上午4:52 2019/6/30
     * @Param []
     * @return com.Jm.JmMqtt.JmMqttCore.JmMqttDataUnity
     **/
    public static JmMqttDataUnity getInstance(){
        return instance;
    }
}
