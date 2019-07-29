package com.Jm.JmMqtt.JmMqttCore;

import com.Jm.JmCommon.common.DateUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;


/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Configuration
public class JmMqttPublishConfigure {

    public static final String JMREG_BACK_MSG_PREFIX = "/Jm/Iot/RegisterResult/";
    private String defaultTopics = "/test";
    private String pubClientIdPrefix = "Jm_Clent_Pub_";

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:27 2019/6/30
     * @Param []
     * @return org.springframework.messaging.MessageHandler
     **/
    @Bean
    @ServiceActivator(inputChannel = "mqttForJmOutChannel")
    public MessageHandler mqttOutbound() {
        ApplicationContext iConfigContex = new AnnotationConfigApplicationContext(JmMqttConfigure.class);
        MqttPahoClientFactory iFactory = (MqttPahoClientFactory) iConfigContex.getBean("JmMqttClientFactory");
        String iClientId =pubClientIdPrefix + "mmm_" + DateUtils.dateTimeNow(DateUtils.YYYYMMDDHHMMSS);

        MqttPahoMessageHandler messageHandler =  new MqttPahoMessageHandler(iClientId, iFactory);
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic(defaultTopics);
        return messageHandler;
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:27 2019/6/30
     * @Param []
     * @return org.springframework.messaging.MessageChannel
     **/
    @Bean
    public MessageChannel mqttForJmOutChannel() {
        return new DirectChannel();
    }
}
