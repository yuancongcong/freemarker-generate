package com.lingxi.generate.web.page;

import com.lingxi.util.Constants;
import com.lingxi.generate.web.GenerateWeb;

public class GeneratePageService extends GenerateWeb {


    public GeneratePageService(String module, String name) {
        super(module,name);
        super.setSubModule(Constants.WEB_VIEW_NAME + "/" + super.getModule() + "/" + super.getName());
        super.setFileName("index.vue");
        super.setTemplateName("page.ftl");
    }

    @Override
    public void push() {
        /** 生成edit **/
        new GeneratePageEditService(super.getModule(),super.getName()).push();
        super.push();
    }
}
