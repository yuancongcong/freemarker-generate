package com.lingxi.generate.java.service;

import com.lingxi.util.Constants;
import com.lingxi.generate.java.GenerateJava;

public class GenerateService extends GenerateJava {


    public GenerateService(String module, String name) {
        super(module,name);
        super.setSubModule(Constants.JAVA_SERVICE_NAME);
        super.setFileName(capitalize(super.getName() + capitalize(super.getSubModule())));
        super.setTemplateName("service.ftl");
    }

}
