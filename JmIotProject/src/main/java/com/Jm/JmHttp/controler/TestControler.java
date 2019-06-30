package com.Jm.JmHttp.controler;

import com.Jm.JmMqtt.JmMqttInterface.JmMqttSendData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @Autowired
    private JmMqttSendData sendOutData;


    @RequestMapping("/")
    @ResponseBody
    public String HandleTest() throws NoSuchMethodException {
        System.out.println("Fuck Is Here");
        sendOutData.SendDataWithTopic(".......///////","/test");
        return "Hello ni Ma Bi";
    }

}
