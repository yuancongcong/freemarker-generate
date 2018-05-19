package com.lingxi.util;

import java.io.InputStream;
import java.util.Properties;

public class Constants {

    private static Properties properties = new Properties();

    private static final String  PROJECT_DIR=  System.getProperty("user.dir");

    static {
        try{
            // 使用ClassLoader加载properties配置文件生成对应的输入流
            InputStream in = Constants.class.getClassLoader().getResourceAsStream("generate.properties");
            // 使用properties对象加载输入流
            properties.load(in);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static String getProperty(String name) {
        System.out.println(PROJECT_DIR);
        return properties.getProperty(name).replace("$ROOT",PROJECT_DIR);
    }

    /**
     * JAVA生成输出目录
     */
    public static String JAVA_OUT_ROOT_PATH =  getProperty("java.out.dir");
    /**
     * JAVA模版目录
     */
    public static String JAVA_TEMPLATE_PATH = getProperty("java.template.dir");

    /**
     * JAVA模版名称
     */
    public static String JAVA_ENTITY_NAME = "entity";
    public static String JAVA_DAO_NAME = "dao";
    public static String JAVA_SERVICE_NAME = "service";
    public static String JAVA_CONTROLLER_NAME = "controller";

    /**
     * WEB生成输出目录
     */
    public static String WEB_OUT_ROOT_PATH = getProperty("web.out.dir");
    /**
     * WEB模板目录
     */
    public static String WEB_TEMPLATE_PATH  = getProperty("web.template.dir");

    /**
     * WEB模版名称
     */
    public static String WEB_VIEW_NAME = "views";
    public static String WEB_SERVICE_NAME = "api";
    
}
