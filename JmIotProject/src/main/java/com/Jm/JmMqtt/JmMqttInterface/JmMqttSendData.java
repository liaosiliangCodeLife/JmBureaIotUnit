package com.Jm.JmMqtt.JmMqttInterface;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Component
@MessagingGateway(defaultRequestChannel = "mqttForJmOutChannel")
public interface JmMqttSendData {
    void SendDataWithTopic(String data,@Header(MqttHeaders.TOPIC) String topic);
}
