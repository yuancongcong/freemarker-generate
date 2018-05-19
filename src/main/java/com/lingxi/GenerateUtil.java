package com.lingxi;

import com.lingxi.generate.java.controller.GenerateController;
import com.lingxi.generate.java.dao.GenerateDao;
import com.lingxi.generate.java.entity.GenerateEntity;
import com.lingxi.generate.java.service.GenerateService;
import com.lingxi.generate.web.page.GeneratePageService;
import com.lingxi.generate.web.service.GenerateWebService;


public class GenerateUtil {

    public static void main(String[] args){
        //包名
        String com = "com.lingxi";
        //模块名称
        String module = "test";
        //数据库对应表名
        String tableName = "t_test";
        //实体类名称
        String name = "test";

        //生成代码Java模版
        GenerateUtil.genJava(com,module,name,tableName);
        //生成代码web模版
        GenerateUtil.genWeb(module,name);
        System.out.println("文件生成结束");
    }


    public static void genJava(String com,String module,String name,String tableName){

        module = com + "." + module;
        //生成 entity
        new GenerateEntity(module,name,tableName).push();
        //生成 dao
        new GenerateDao(module,name).push();
        //生成 service
        new GenerateService(module,name).push();
        //生成 controller
        new GenerateController(module,name).push();
    }

    public static void genWeb(String module,String name){
        String web_module = module.substring(module.lastIndexOf(".")+1);

        //生成 web service
        new GenerateWebService(web_module,name).push();
        //生成 web pages
        new GeneratePageService(web_module,name).push();
    }
}
