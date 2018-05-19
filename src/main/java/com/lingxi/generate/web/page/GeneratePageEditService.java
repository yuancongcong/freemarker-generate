package com.lingxi.generate.web.page;

import com.lingxi.util.Constants;
import com.lingxi.generate.web.GenerateWeb;

public class GeneratePageEditService extends GenerateWeb {


    public GeneratePageEditService(String module, String name) {
        super(module,name);
        super.setSubModule(Constants.WEB_VIEW_NAME + "/" + super.getModule() + "/" + super.getName());
        super.setFileName("edit.vue");
        super.setTemplateName("page-edit.ftl");
    }

}
