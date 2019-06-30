package com.Jm.JmThreadPool;


import com.Jm.JmMqtt.JmMqttCore.JmMqttHandler;
import com.Jm.JmMqtt.JmMqttInterface.JmMqttHandlerServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Service
public class JmAsynTaskImpl implements JmAsynServices {
    private static final Logger taskLogger =  LoggerFactory.getLogger(JmMonitorTaskExecutor.class);
    @Override
    @Async("asyncJmServiceExecutor")
    public void exeJmIotMainTask(JmMqttHandlerServices vHandler, String vTopic, String vPayload) {
        vHandler.IotMqttMainHanlder(vTopic, vPayload);
    }
}
