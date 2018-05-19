package com.lingxi.generate.java.entity;

import com.lingxi.util.Constants;
import com.lingxi.generate.java.GenerateJava;

public class GenerateEntity extends GenerateJava {


    public GenerateEntity(String module, String name,String tableName) {
        super(module,name);
        super.setSubModule(Constants.JAVA_ENTITY_NAME);
        super.setFileName(capitalize(super.getName()));
        super.setTemplateName("entity.ftl");
        super.dataPush("table_name",tableName);
    }
}
