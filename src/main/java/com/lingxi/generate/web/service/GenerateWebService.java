package com.lingxi.generate.web.service;

import com.lingxi.util.Constants;
import com.lingxi.generate.web.GenerateWeb;

public class GenerateWebService extends GenerateWeb {


    public GenerateWebService(String module, String name) {
        super(module,name);
        super.setSubModule(Constants.WEB_SERVICE_NAME + "/" + super.getModule());
        super.setFileName(super.getName() + ".js");
        super.setTemplateName("service.ftl");
    }

}
