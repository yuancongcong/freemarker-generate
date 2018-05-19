package com.lingxi.generate.web;

import com.lingxi.util.Constants;
import com.lingxi.generate.Generate;
import freemarker.template.Template;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class GenerateWeb extends Generate {

    public GenerateWeb(String module, String name) {
        super(module,name);
    }

    @Override
    public void push(){
        //获取模版
        Template template = getTemplate(this.getTemplateName(), Constants.WEB_TEMPLATE_PATH);
        //输出文件
        String outFile = Constants.WEB_OUT_ROOT_PATH + "/" + this.getSubModule()+ "/" + this.getFileName();
        //写入
        super.write(template,outFile,getData());
    }

    public Map<String,Object> getData(){
        Map<String,Object> data = new HashMap<>();
        data.put("module",this.getModule());
        data.put("module_name",this.getModule());
        data.put("name",this.getName());
        data.put("var_service_name", this.getName() + capitalize(Constants.WEB_SERVICE_NAME) );
        return  data;
    }
}
