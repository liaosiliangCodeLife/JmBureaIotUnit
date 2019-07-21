package com.Jm.JmHttp.controler;

import com.Jm.JmDataBase.DataType.HttpResonseData;
import com.Jm.JmDataBase.DataType.JmDevicesDataType;
import com.Jm.JmMqtt.JmMqttCore.JmMqttDataUnity;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 11:43 2019/7/21
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("/")
    @ResponseBody
    public String HandleTest() throws NoSuchMethodException {
        return "Hello ni Ma Bi";
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 11:43 2019/7/21
     * @Param []
     * @return java.lang.String
     **/
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

    /*
     * @Author Liaosiliang
     * @Description //TODO
     * @Date 下午4:39 2019/7/5
     * @Param [id]
     * @return java.lang.String
     **/
    @RequestMapping("/testSetAlarm/{id}")
    @ResponseBody
    public String testAlarm(@PathVariable("id") String id){
        JmMqttDataUnity.getInstance().setDevicesAlarmValue(10000, id);
        return id;
    }

}
