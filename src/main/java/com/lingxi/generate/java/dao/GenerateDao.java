package com.lingxi.generate.java.dao;

import com.lingxi.util.Constants;
import com.lingxi.generate.java.GenerateJava;

public class GenerateDao extends GenerateJava {


    public GenerateDao(String module, String name) {
        super(module,name);
        super.setSubModule(Constants.JAVA_DAO_NAME);
        super.setFileName(capitalize(super.getName() + capitalize(super.getSubModule())));
        super.setTemplateName("dao.ftl");
    }

}
