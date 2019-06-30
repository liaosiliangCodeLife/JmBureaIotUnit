package com.Jm.JmThreadPool;

import com.Jm.JmMqtt.JmMqttCore.JmMqttHandler;
import com.Jm.JmMqtt.JmMqttInterface.JmMqttHandlerServices;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
public interface JmAsynServices {
    public void exeJmIotMainTask(JmMqttHandlerServices vHandler, String vTopic, String vPayload);
}
