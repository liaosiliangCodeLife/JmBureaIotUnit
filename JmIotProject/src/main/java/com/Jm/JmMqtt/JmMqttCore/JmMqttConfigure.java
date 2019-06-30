package com.Jm.JmMqtt.JmMqttCore;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;


/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Configuration
public class JmMqttConfigure {
    private static final Logger mqttLogger =  LoggerFactory.getLogger(JmMqttConfigure.class);
    private String[]   hostUrls = {"tcp://47.104.183.238:1883"};
    private String   userName = "JmBurea";
    private String   userPwd = "123456";

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:26 2019/6/30
     * @Param []
     * @return org.eclipse.paho.client.mqttv3.MqttConnectOptions
     **/
    @Bean
    public MqttConnectOptions JmMqttConnectOptions(){
        mqttLogger.info("Configure the mqtt client with user name: " + userName);
        mqttLogger.info("Configure the mqtt client with user pwd: " +  userPwd);
        for(int i=0; i<hostUrls.length; i++){
            mqttLogger.info("Configure the mqtt client with host: " +  hostUrls[i]);
        }

        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setUserName(userName);
        mqttConnectOptions.setPassword(userPwd.toCharArray());
        mqttConnectOptions.setServerURIs(hostUrls);
        mqttConnectOptions.setKeepAliveInterval(30);
        return mqttConnectOptions;
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:26 2019/6/30
     * @Param []
     * @return org.springframework.integration.mqtt.core.MqttPahoClientFactory
     **/
    @Bean
    public MqttPahoClientFactory JmMqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setConnectionOptions(JmMqttConnectOptions());
        return factory;
    }
}
