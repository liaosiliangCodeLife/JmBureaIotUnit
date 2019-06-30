package com.Jm.JmMqtt.JmMqttCore;

import com.Jm.JmCommon.base.JmMqttUntils;
import com.Jm.JmMqtt.JmMqttInterface.JmMqttHandlerServices;
import com.Jm.JmThreadPool.JmAsynServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import java.lang.annotation.Annotation;

/*
 *@ProjectName Jm Burea Iot Project
 *@Time 2019/6/28 下午4:54
 *@Author Liaosiliang
 *@Version 1.0.
 *@Email <liaosiliang1234@126.com>
 *@Copyright reserve by LSL
 */
@Configuration
public class JmMqttSubscriberConfigure {
    private static final Logger mqttLogger =  LoggerFactory.getLogger(JmMqttConfigure.class);
    private String   clientIdPrefix = "Jm_Clent_Sub_";
    private int      subQos = 2;
    private int      subTimeOut = 2000;

    @Autowired
    private JmAsynServices mqttThreadPool;

    @Autowired
    JmMqttHandlerServices mqttMsgHandler;

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:27 2019/6/30
     * @Param []
     * @return org.springframework.messaging.MessageChannel
     **/
    @Bean
    public MessageChannel mqttForJmInputChannel() {
        return new DirectChannel();
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:28 2019/6/30
     * @Param []
     * @return org.springframework.integration.core.MessageProducer
     **/
    @Bean
    public MessageProducer inbound() {
        ApplicationContext iConfigContex = new AnnotationConfigApplicationContext(JmMqttConfigure.class);
        MqttPahoClientFactory iFactory = (MqttPahoClientFactory) iConfigContex.getBean("JmMqttClientFactory");

        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                clientIdPrefix + "www",
                iFactory,
                "/Test"
        );
        mqttLogger.info("Mqtt subscrible the with client id: " + clientIdPrefix + "www");
        String[] iTopics = JmMqttUntils.getAllTopicFromClass(JmMqttHandler.class);

        for(int i =0; i< iTopics.length; i++){
            adapter.addTopic( iTopics[i], subQos);
            mqttLogger.info("Mqtt subscrible the with topic: " + iTopics[i]);
        }

        adapter.setCompletionTimeout(subTimeOut);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setOutputChannel(mqttForJmInputChannel());
        return adapter;
    }

    /*
     * @Author Liaosiliang
     * @Description //TODO 
     * @Date 下午12:28 2019/6/30
     * @Param []
     * @return org.springframework.messaging.MessageHandler
     **/
    @Bean
    @ServiceActivator(inputChannel = "mqttForJmInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                String iTopic = message.getHeaders().get("mqtt_receivedTopic").toString();
                mqttLogger.info("Recive the topic: " + iTopic);
                mqttLogger.info("Recive mqtt payload: " + message.getPayload().toString());
                mqttThreadPool.exeJmIotMainTask(mqttMsgHandler, iTopic, message.getPayload().toString());
            }
        };
    }
}
