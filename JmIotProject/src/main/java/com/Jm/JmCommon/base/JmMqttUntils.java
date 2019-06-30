package com.Jm.JmCommon.base;

import com.Jm.JmCommon.annotation.SubTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@Scope
public class JmMqttUntils {
    private static final Logger mqttLogger =  LoggerFactory.getLogger(JmMqttUntils.class);
    static public final String HUM_STR = "Humunity";
    static public final String TEM_STR = "Temperature";
    static public final String FAN_STR = "AirCondition";

    static public final int HUM_CODE = 1;
    static public final int TEM_CODE = 2;
    static public final int FAN_CODE = 3;

    static public final int OK_CODE = 0;
    static public final int ALREADY_EXITS_CODE = 101;

    static public final String[] DEV_TYPE_MAP = {"", HUM_STR, TEM_STR, FAN_STR};
    static public final String[] DEV_UNITY_MAP = {"", "%", "C", "rod"};
    static public final String   DEV_ALARM_VALUE = "50.00";
    static public final String   DATA_DEFAULT_STR = "N";

    static public final String  EXCEL_DOWNFILE_PATH = "/home/execl/";

    static private  String byteArryToString(byte[] vArry){
        StringBuffer resultCache = new StringBuffer();
        for(int i = 0; i<vArry.length; i++){
            byte data = vArry[i] > 0 ? vArry[i]: (byte) (vArry[i] + 256);
            resultCache.append(String.format("%02x",data));
        }
        return resultCache.toString();
    }

    public static String generateDevId(String vStr){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return byteArryToString(md5.digest(vStr.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            mqttLogger.error("Without detected the MD5 Algorithm!");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            mqttLogger.error("Unsupport encode UTF-8!");
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String[] getAllTopicFromClass(Class<T> vClass){
        List<String> iCacheStr = new ArrayList<String>();
        Method[] iMethods = vClass.getDeclaredMethods();
        for(int i =0; i<iMethods.length; i++){
            SubTopic iTopic = iMethods[i].getAnnotation(SubTopic.class);
            if(null!=iTopic){
                iCacheStr.add(iTopic.name());
            }
        }
        return iCacheStr.toArray(new String[0]);
    }
}
