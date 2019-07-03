package com.Jm.JmHttp.controler;

import com.Jm.JmDataBase.DataType.HttpResonseData;
import com.Jm.JmDataBase.DataType.JmDevicesDataType;
import com.Jm.JmMqtt.JmMqttCore.JmMqttDataUnity;
import com.Jm.JmMqtt.JmMqttInterface.JmMqttSendData;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RestController
public class TestControler {

    @RequestMapping("/")
    @ResponseBody
    public String HandleTest() throws NoSuchMethodException {
        System.out.println("Fuck Is Here");
        return "Hello ni Ma Bi";
    }

    @RequestMapping("/getAllDev")
    @ResponseBody
    public String handleGetAll(){
        List<JmDevicesDataType> tmp = JmMqttDataUnity.getInstance().getDevListData();
        List<HttpResonseData> httpData = new ArrayList<>();
        for(int i =0; i<tmp.size(); i++){
            HttpResonseData iTmp = new HttpResonseData(tmp.get(i));
            httpData.add(iTmp);
        }
        return JSON.toJSONString(httpData);
    }


}
