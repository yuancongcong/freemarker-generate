package com.lingxi.generate.java.controller;

import com.lingxi.util.Constants;
import com.lingxi.generate.java.GenerateJava;

public class GenerateController extends GenerateJava {

    public GenerateController(String module, String name) {
        super(module,name);
        super.setSubModule(Constants.JAVA_CONTROLLER_NAME);
        super.setFileName(capitalize(super.getName() + capitalize(super.getSubModule())));
        super.setTemplateName("controller.ftl");
    }
}
